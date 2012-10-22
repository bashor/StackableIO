import java.io.Writer

abstract class BaseWriter extends Writer with OutBuffering with BaseTranslation {
  protected val writer: Writer

  def write(buf: Array[Char], off: Int, len: Int) {
    writer.write(buf, off, len)
  }

  def flush() {
    writer.flush()
  }

  def close() {
    writer.close()
  }
}