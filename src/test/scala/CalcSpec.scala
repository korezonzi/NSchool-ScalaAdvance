import org.scalatest.{DiagrammedAssertions, FlatSpec}
import org.scalatest.concurrent.TimeLimits._
import org.scalatest.time.SpanSugar._

class CalcSpec  extends FlatSpec with DiagrammedAssertions {
  val calc = new Calc
  "sum関数" should "整数の配列を取得、それらの和の合計" in {
    assert(calc.sum(Seq(1,2,3)) === 6)
    assert(calc.sum(Seq(0))     === 0)
  }

  it should "Intの最大値を上回った場合、エラー処理" in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  "div関数" should "整数を2つ受け取り、分子を分母で割った浮動小数点の値を返す" in {
    assert(calc.div(6, 3) === 2.0)
  }

  it should "0で割るときはエラー" in {
    intercept[ArithmeticException] {
      calc.div(1,0)
    }
  }

  "isPrime関数" should "素数かの判別" in {
    assert(calc.isPrime(0) === false)
  }

  it should "include process time is 1s" in {
    failAfter(1000 millis) {
      assert(calc.isPrime(999991))
    }
  }
}
