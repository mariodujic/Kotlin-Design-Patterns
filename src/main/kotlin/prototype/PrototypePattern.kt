package prototype

fun main() {
    val orangeJuice = Liquid("Orange Juice", "Orange", 300.0f)
    val appleJuice = orangeJuice.copy(name = "Apple Juice", color = "Green")
    println(appleJuice)
}

private data class Liquid(
    val name: String,
    val color: String,
    val amount: Float
)