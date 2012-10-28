trait ToUpper extends BaseTranslation {
  protected abstract override def translate(char: Char): Option[Char] = super.translate(char) match {
    case Some(newChar) => Some(char.toUpper)
    case _ => None
  }
}

trait StripWhiteSpace extends BaseTranslation {
  protected abstract override def translate(char: Char): Option[Char] = super.translate(char) match {
    case Some(newChar) => if (char.isWhitespace) None else Some(char)
    case _ => None
  }
}

trait AsciiOnly extends BaseTranslation {
  protected abstract override def translate(char: Char): Option[Char] = super.translate(char) match {
    case Some(newChar) => {
      if (((char & 0x7F) ^ char) == 0)
        Some(char)
      else
        None
    }
    case _ => None
  }
}
