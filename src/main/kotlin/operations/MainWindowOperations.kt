package operations

import models.RegexModel
import ui.MainWindow
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import org.jsoup.*
import services.RegexService
import java.net.URL

class MainWindowOperations(
    private val _mainComponent: MainWindow
) : MouseAdapter()
{
    private val _service = RegexService()
    override fun mouseClicked(e: MouseEvent?) {
        if (e == null)
        {
            return
        }

        when(e.component.name)
        {
            "Button" -> onButtonClick()
        }
    }

    private fun onButtonClick() {
        if (_mainComponent.url.text.isEmpty())
        {
            return
        }

        val url = URL(_mainComponent.url.text)
        val doc = Jsoup.parse(url, 5000)

        val regexModel = RegexModel(doc.html())

        val replacedText = _service.execute(regexModel)

        _mainComponent.editor.text = replacedText
    }
}