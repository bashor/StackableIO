import java.io.Reader

abstract class BaseReader extends Reader with OutBuffering with BaseTranslation {
  protected val reader: Reader

  def read(buf: Array[Char], off: Int, len: Int): Int = {
    var allReadCount = 0
    do {
      val readCount = reader.read(buf, off + allReadCount, len - allReadCount)
      if (readCount == -1)
        return allReadCount

      var i = off + allReadCount
      val end = i + readCount - 1
      for (j <- i to end; tr = translate(buf(j)); if tr.isDefined) {
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