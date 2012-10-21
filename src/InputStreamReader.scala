import java.io.{Reader, InputStream}

abstract class BaseReader[T](in: T) extends Reader with OutBuffering with BaseTranslate {
  protected val reader: Reader

  def read(buf: Array[Char], off: Int, len: Int): Int = {
    var allReadCount = 0
    do {
      val readCount = reader.read(buf, off + allReadCount, len - allReadCount)
      if (readCount == -1)
        return allReadCount

      var i = off + allReadCount
      for (el <- buf; tr = translate(el); if tr.isDefined) {
        buf(i) = tr.get
        i += 1
      }

      allReadCount = i
    } while (len > allReadCount)

    allReadCount
  }

  def close() {
    reader.close()
  }
}

class InputStreamReader(in: InputStream) extends BaseReader(in) {
  protected val reader = bufferingStrategy(new java.io.InputStreamReader(in))
}

class StringReader(string: String) extends BaseReader(string) {
  protected val reader = bufferingStrategy(new java.io.StringReader(string))
}

class PipedReader(pipe:java.io.PipedWriter) extends  BaseReader(pipe) {
  protected val reader = bufferingStrategy(new java.io.PipedReader(pipe))
}

object Main {
  def main(args: Array[String]) {
    val wo = new InputStreamReader(System.in) with ToUpper
    val w = new InputStreamReader(System.in) with Buffering with ToUpper
    val a = 1
  }
}