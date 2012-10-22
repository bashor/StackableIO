trait ToUpper extends Translation {
  protected abstract override def translate(char: Char): Option[Char] = Some(char.toUpper)
}

trait StripWhiteSpace extends Translation {
  protected abstract override def translate(char: Char): Option[Char] = if (char.isWhitespace) None else Some(char)
}

trait AsciiOnly extends Translation {
  protected abstract override def translate(char: Char): Option[Char] = {
//    println((char & 0x7F))
//    println(char)
    if (((char & 0x7F) ^ char) == 0)
      Some(char)
    else
      None
  }
}
