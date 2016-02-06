package hatena.intern

import scala.io.Source

object LtsvParser {
  def parse(filePath: String): Iterable[Log] = {
    val source = Source.fromFile(filePath)
    source.getLines().map(this.parseLine).toIterable
  }

  private def parseLine(line: String): Log = {
    val map: Map[String, String] = line.split("\t").map((item: String) => {
      val kv = item.split(":", 2)
      (kv(0), kv(1))
    }).toMap

    Log(
      host = map("host"),
      user = if (map("user") == "-") None else Some(map("user")),
      epoch = map("epoch").toInt,
      req = map("req"),
      status = map("status").toInt,
      size = map("size").toInt,
      referer = if (map("referer") == "-") None else Some(map("referer"))
    )
  }
}
