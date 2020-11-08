package adapter

fun main() {
    val celsiusTemperature = CelsiusTemperature(20.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    println("20 temperature celsius is ${fahrenheitTemperature.temperature} fahrenheit temperature")
}

interface Temperature {
    var temperature: Double
}

class CelsiusTemperature(override var temperature: Double) : Temperature

class FahrenheitTemperature(private var celsiusTemperature: CelsiusTemperature) : Temperature {


    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(tempInFar) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(tempInFar)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double = (f - 32) * 5 / 9

    private fun convertCelsiusToFahrenheit(c: Double): Double = (c * 9 / 5) + 32
}