package hatena.intern

case class LogCounter(logs: Iterable[Log]) {
  def countError: Int = {
    logs.count(_.status / 100 == 5)
  }

  type User = String
  def groupByUser: Map[User, Iterable[Log]] = ???
}
