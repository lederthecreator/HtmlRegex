package ui

import operations.MainWindowOperations
import java.awt.Dimension
import javax.swing.*

class MainWindow() : JFrame()
{
    private val _button = JButton()
    private val _controller = MainWindowOperations(this)

    val url = JTextField()
    val editor = JEditorPane()

    init {
        minimumSize = Dimension(780, 480)
        defaultCloseOperation = EXIT_ON_CLOSE

        url.minimumSize = Dimension(600, 40)
        _button.minimumSize = Dimension(110, 40)

        // val editorSize = Dimension(755, 380)
        editor.apply {
            autoscrolls = true
            isEditable = false
            contentType = "text/html"
        }

        _button.text = "I'm feeling lucky"

        configureNames()
        setupLayout()
        setupHandlers()
    }

    private fun configureNames() {
        url.name = "UrlTextField"
        editor.name = "EditorPane"
        _button.name = "Button"
    }

    private fun setupHandlers() {
        _button.addMouseListener(_controller)
    }

    private fun setupLayout() {
        val urlPanel = JPanel()
        val scrPane = JScrollPane(editor)

        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(5)
                    .addGroup(
                        createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(urlPanel, SHRINK, SHRINK, SHRINK)
                            .addComponent(scrPane, 350, 1080, GROW)
                    )
                    .addGap(5)
            )
            setVerticalGroup(
                createSequentialGroup()
                    .addGap(5)
                    .addComponent(urlPanel, SHRINK, SHRINK, SHRINK)
                    .addGap(10)
                    .addComponent(scrPane, 350, 1920, GROW)
                    .addGap(5)
            )
        }

        urlPanel.layout = GroupLayout(urlPanel).apply {
            setHorizontalGroup(
                createSequentialGroup()
                    .addGap(5)
                    .addComponent(url)
                    .addGap(23)
                    .addComponent(_button)
                    .addGap(5)
            )
            setVerticalGroup(
                createParallelGroup()
                    .addGap(5)
                    .addComponent(url)
                    .addComponent(_button)
                    .addGap(5)
            )
        }
    }

    companion object{
        const val SHRINK = GroupLayout.PREFERRED_SIZE
        const val GROW = GroupLayout.DEFAULT_SIZE
    }
}