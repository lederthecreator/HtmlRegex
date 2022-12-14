package services

import models.RegexModel
import objects.RegExps

class RegexService {
    private val _emailRegex = RegExps.emailRegex
    private val _urlRegex = RegExps.urlRegex

    fun execute(model: RegexModel): String {
        val text = model.htmlSource

        val replacedLeftBraces = replaceLeftBraces(text)
        val replacedRightBraces = replaceRightBraces(replacedLeftBraces)

        val replacedEmailText = replaceEmails(replacedRightBraces)

        return replaceUrls(replacedEmailText)
    }

    private fun replaceLeftBraces(text: String) : String = "<".toRegex().replace(text) {
        "&lt;"
    }

    private fun replaceRightBraces(text: String) : String = ">".toRegex().replace(text) {
        "&gt;"
    }

    fun replaceEmails(text: String) : String = _emailRegex.replace(text) {
            "<a href = ${it.value}>${it.value}</a>"
        }

    fun replaceUrls(text: String) : String = _urlRegex.replace(text) {
        "<a href=\"${it.value}\">${it.value}</a>"
    }
}