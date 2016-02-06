package hatena.intern

import scala.io.Source

object LtsvParser {
  def parse(filePath: String): Iterable[Log] = {
    val source = Source.fromFile(filePath)
    source.getLines().map((line: String) => {
      val map: Map[String, String] = line.split("\t").map((item: String) => {
        val kv = item.split(":", 2)
        (kv(0), kv(1))
      }).toMap

      Log(
        host = map.getOrElse("host", ""),
        user = map.getOrElse("user", ""),
        epoch = map.getOrElse("epoch", "0").toInt,
        req = map.getOrElse("req", ""),
        status = map.getOrElse("status", "0").toInt,
        size = map.getOrElse("size", "0").toInt,
        referer = map.getOrElse("referer", "")
      )
    }).toIterable
  }
}
