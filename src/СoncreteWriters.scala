import java.io.OutputStream

class OutputStreamWriter(out: OutputStream) extends BaseWriter {
  protected val writer = applyStrategy(new java.io.OutputStreamWriter(out))
}

class StringWriter(size: Int) extends BaseWriter {
  protected val writer = applyStrategy(new java.io.StringWriter(size))
}

class PipedWriter(pipe:java.io.PipedReader) extends  BaseWriter {
  protected val writer = applyStrategy(new java.io.PipedWriter(pipe))
}