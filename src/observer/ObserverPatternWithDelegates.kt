package observer

import kotlin.properties.Delegates

interface ValueChangeLister {
    fun onValueChanged(value: Int)
}

class TemperatureChangeListener : ValueChangeLister {
    override fun onValueChanged(value: Int) {
        println("New temperature is $value")
    }
}

class TemperatureObservable(listener: ValueChangeLister) {
    var temperature: Int by Delegates.observable(
        initialValue = 0,
        onChange = { _, _, newValue -> listener.onValueChanged(newValue) }
    )
}

fun main() {
    val temperatureListener: ValueChangeLister =
        TemperatureChangeListener()
    val temperatureObservable = TemperatureObservable(temperatureListener)
    temperatureObservable.temperature = 25
    temperatureObservable.temperature = 33
}
