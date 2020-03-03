package observer

import kotlin.properties.Delegates


fun main() {
    val observableObject = ObservableObject(PrintingTextChangedListener())
    observableObject.text = "First hello"
    observableObject.text = "Second hello"
}

interface ValueChangeListener {
    fun onValueChanged(newValue: String)
}

class PrintingTextChangedListener: ValueChangeListener {
    override fun onValueChanged(newValue: String) {
        println("Text changed to $newValue")
    }
}

class ObservableObject(listener: ValueChangeListener) {
    var text: String by Delegates.observable(
        initialValue = "",
        onChange = {
            _, _, newValue -> listener.onValueChanged(newValue)
        }
    )
}