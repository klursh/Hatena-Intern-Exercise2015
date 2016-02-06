package hatena.intern

import scala.collection.mutable

case class LogCounter(logs: Iterable[Log]) {
  def countError: Int = {
    logs.count(_.status / 100 == 5)
  }

  type User = String
  def groupByUser: Map[User, Iterable[Log]] = {
    val map = mutable.Map[User, Seq[Log]]()
    logs.foreach((log: Log) => {
      val user = log.user.getOrElse("guest")
      if (map.isDefinedAt(user)) {
        map(user) = map(user) :+ log
      } else {
        map(user) = Seq(log)
      }
    })
    map.toMap
  }
}
