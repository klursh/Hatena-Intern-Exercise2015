package hatena.intern

import hatena.intern.helper._

class Exercise2Spec extends UnitSpec {

  describe("LTSV Parser") {
    it("LTSVファイルが正しくパースされていること") {
      val logs = LtsvParser.parse("../sample_data/log.ltsv")
      logs.size shouldBe 5

      val logSeq: Seq[Log] = logs.toSeq
      logSeq(0).method shouldBe "GET"
      logSeq(0).path shouldBe "/apache_pb.gif"
      logSeq(0).protocol shouldBe "HTTP/1.0"
      logSeq(0).uri shouldBe "http://127.0.0.1/apache_pb.gif"
      logSeq(0).time shouldBe "2013-07-01T15:59:50"
      logSeq(0).user shouldBe Some("frank")
      logSeq(0).referer shouldBe Some("http://www.hatena.ne.jp/")

      logSeq(1).method shouldBe "GET"
      logSeq(1).path shouldBe "/apache_pb.gif"
      logSeq(1).protocol shouldBe "HTTP/1.0"
      logSeq(1).uri shouldBe "http://127.0.0.1/apache_pb.gif"
      logSeq(1).time shouldBe "2013-07-02T19:46:30"
      logSeq(1).user shouldBe Some("john")
      logSeq(1).referer shouldBe Some("http://b.hatena.ne.jp/hotentry")

      logSeq(2).method shouldBe "GET"
      logSeq(2).path shouldBe "/apache_pb.gif"
      logSeq(2).protocol shouldBe "HTTP/1.0"
      logSeq(2).uri shouldBe "http://127.0.0.1/apache_pb.gif"
      logSeq(2).time shouldBe "2013-07-03T23:33:10"
      logSeq(2).user shouldBe None
      logSeq(2).referer shouldBe Some("http://www.example.com/start.html")

      logSeq(3).method shouldBe "GET"
      logSeq(3).path shouldBe "/apache_pb.gif"
      logSeq(3).protocol shouldBe "HTTP/1.0"
      logSeq(3).uri shouldBe "http://127.0.0.1/apache_pb.gif"
      logSeq(3).time shouldBe "2013-07-01T15:59:50"
      logSeq(3).user shouldBe Some("frank")
      logSeq(3).referer shouldBe Some("http://www.hatena.ne.jp/")

      logSeq(4).method shouldBe "GET"
      logSeq(4).path shouldBe "/notfound.gif"
      logSeq(4).protocol shouldBe "HTTP/1.0"
      logSeq(4).uri shouldBe "http://127.0.0.1/notfound.gif"
      logSeq(4).time shouldBe "2013-07-02T19:46:35"
      logSeq(4).user shouldBe Some("frank")
      logSeq(4).referer shouldBe None
    }

    it("LTSVファイルが正しくパースできない形式の場合") {
      // エラーハンドリングの設計を考えながら、テストを書いてみてください
    }

    it("LTSVファイルが存在しない場合") {
      // エラーハンドリングの設計を考えながら、テストを書いてみてください
    }
  }

}
