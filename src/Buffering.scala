import java.io.{BufferedWriter, BufferedReader, Writer, Reader}

trait BufferingStrategy {
  protected def bufferingStrategy(reader: Reader): Reader
  protected def bufferingStrategy(reader: Writer): Writer
}

trait OutBuffering extends BufferingStrategy {
  protected def bufferingStrategy(reader: Reader) = reader
  protected def bufferingStrategy(writer: Writer) = writer
}

trait Buffering extends BufferingStrategy {
  protected abstract override def bufferingStrategy(reader: Reader) = new BufferedReader(reader)
  protected abstract override def bufferingStrategy(writer: Writer) = new BufferedWriter(writer)
}