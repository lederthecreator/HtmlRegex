package objects

object RegExps {
    val urlRegex = Regex("(?:(?:https?|ftp|file):\\/\\/|www\\.|ftp\\.)(?:\\([-A-Z0-9+&@#\\/%=~_|\$?!:,.]*\\)|[-A-Z0-9+&@#\\/%=~_|\$?!:,.])*(?:\\([-A-Z0-9+&@#\\/%=~_|\$?!:,.]*\\)|[A-Z0-9+&@#\\/%=~_|\$])",
        setOf(RegexOption.MULTILINE, RegexOption.IGNORE_CASE))

    val emailRegex = Regex("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}",
        RegexOption.MULTILINE)

    val four = 2 + 2
}