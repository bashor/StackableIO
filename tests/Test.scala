import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers._
import org.scalamock.scalatest.MockFactory

@RunWith(classOf[JUnitRunner])
class Test extends FunSuite with MockFactory {

  test("skip reading") {
    val expected = Array('a','b', 'c')
    val reader = new StringReader("\uFF00ab\uFF00\uFF00c") with AsciiOnly

    val buf = Array.fill(expected.size)('\0')
    val readCount = reader.read(buf)

    readCount should equal (expected.size)
    buf should equal (expected)
  }

  test("mix some translations") {
    val expected = Array('A','B', 'C')
    val reader = new StringReader("\uFF00ab\uFF00\uFF00c") with AsciiOnly with ToUpper

    val buf = Array.fill(expected.size)('\0')
    val readCount = reader.read(buf)

    readCount should equal (expected.size)
    buf should equal (expected)
  }

  test("buffering") {
    // in progress
    //    trait mockWithCallCounter extends Translation {
    //      var callCount = 0
    //      protected abstract override def translate(char: Char): Option[Char] = {
    //        callCount+=1
    //        Some(char)
    //      }
    //    }

    val input = new java.io.Reader(){
      var isBuffered = false
      def read(cbuf: Array[Char], off: Int, len: Int) = {
        isBuffered = len > 1
        3
      }
      def close() {}
    }

    //    val expected = Array(input(0))
    //    val reader = new InputStreamReader(input) with Buffering

    //    val buf = Array('\0')
    //    val readCount = reader.read(buf)

    //    readCount should equal (1)
    //    buf should equal (expected)
    //    reader.callCount should equal (input.size)
  }
}
