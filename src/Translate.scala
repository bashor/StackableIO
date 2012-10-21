trait Translate {
  protected def translate(char: Char): Option[Char]
}

trait BaseTranslate extends Translate {
  protected def translate(char: Char) = Some(char)
}

trait ToUpper extends Translate {
  protected abstract override def translate(char: Char) = Some(char.toUpper)
}

trait ToLower extends Translate {
  protected abstract override def translate(char: Char) = Some(char.toLower)
}

trait StripWhiteSpace extends Translate {
  protected abstract override def translate(char: Char) = if (char.isWhitespace) None else Some(char)
}

trait DigitOnly extends Translate {
  protected abstract override def translate(char: Char) = if (char.isDigit) None else Some(char)
}

trait LetterOnly extends Translate {
  protected abstract override def translate(char: Char) = if (char.isLetter) None else Some(char)
}

trait AsciiOnly extends Translate {
  protected abstract override def translate(char: Char) = if ((char & 0x7F) == char) Some(char) else None
}
