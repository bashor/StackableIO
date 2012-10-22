import java.io.{BufferedWriter, BufferedReader, Writer, Reader}

trait BufferingStrategy {
  protected def applyStrategy(reader: Reader): Reader
  protected def applyStrategy(reader: Writer): Writer
}

trait OutBuffering extends BufferingStrategy {
  protected def applyStrategy(reader: Reader) = reader
  protected def applyStrategy(writer: Writer) = writer
}

trait Buffering extends BufferingStrategy {
  protected abstract override def applyStrategy(reader: Reader) = new BufferedReader(reader)
  protected abstract override def applyStrategy(writer: Writer) = new BufferedWriter(writer)
}