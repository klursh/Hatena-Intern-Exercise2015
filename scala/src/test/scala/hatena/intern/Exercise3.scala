package hatena.intern

import hatena.intern.helper._

class Exercise3Spec extends UnitSpec {
  describe("LTSV Counter") {

    val logs = LtsvParser.parse("../sample_data/log.ltsv") // リポジトリ内の`sample_data/log.ltsv`へのパスを指定してください

    it("エラー数が正しくカウントされていること") {
      LogCounter(logs).countError shouldBe 2
    }

    it("ユーザごとにログがグループ化されていること") {
      val groupdLogs = LogCounter(logs).groupByUser
      val franksLogs = groupdLogs.get("frank").get

      groupdLogs.get("john").size shouldBe 1
      groupdLogs.get("guest").size shouldBe 1

      franksLogs.size shouldBe 3
      franksLogs.forall(_.user.get == "frank") shouldBe true
      franksLogs.toSeq(0).status shouldBe 200
      franksLogs.toSeq(1).status shouldBe 500
      franksLogs.toSeq(2).status shouldBe 404
    }
  }

}
