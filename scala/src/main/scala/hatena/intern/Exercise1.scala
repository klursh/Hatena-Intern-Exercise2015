package hatena.intern

import org.joda.time.{ DateTimeZone, DateTime }

case class Log(host: String, user: Option[String], epoch: Int, req: String, status: Int, size: Int, referer: Option[String]) {
  def method: String = req.split(" ")(0)

  def path: String = req.split(" ")(1)

  def protocol: String = req.split(" ")(2)

  def uri: String = "http://" + host + this.path

  val dt: DateTime = new DateTime(epoch.toLong * 1000, DateTimeZone.UTC)

  def time: String = dt.toString("yyyy-MM-dd'T'HH:mm:ss")
}
