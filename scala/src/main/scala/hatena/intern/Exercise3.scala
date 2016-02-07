package hatena.intern

import scala.collection.mutable

case class LogCounter(logs: Iterable[Log]) {
  def countError: Int = {
    logs.count(_.status / 100 == 5)
  }

  type User = String
  def groupByUser: Map[User, Iterable[Log]] = {
    logs.groupBy(_.user.getOrElse("guest"))
  }
}
