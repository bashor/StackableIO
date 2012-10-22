import java.io.InputStream

class InputStreamReader(in: InputStream) extends BaseReader {
  protected val reader = applyStrategy(new java.io.InputStreamReader(in))
}

class StringReader(string: String) extends BaseReader {
  protected val reader = applyStrategy(new java.io.StringReader(string))
}

class PipedReader(pipe:java.io.PipedWriter) extends  BaseReader {
  protected val reader = applyStrategy(new java.io.PipedReader(pipe))
}