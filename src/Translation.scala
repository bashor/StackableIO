trait Translation {
  protected def translate(char: Char): Option[Char]
}

trait BaseTranslation extends Translation {
  protected def translate(char: Char): Option[Char] = Some(char)
}