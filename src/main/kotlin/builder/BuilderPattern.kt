package builder

fun main() {
    val samsungGalaxy = Phone.Builder()
        .setBrand("Samsung")
        .setColor("White")
        .setTouchScreen(true)
        .build()

    println("Brand: ${samsungGalaxy.brand}")
    println("Color: ${samsungGalaxy.color}")
    println("Touch screen: ${samsungGalaxy.isTouchScreen}")
}

private data class Phone private constructor(
    val brand: String?,
    val color: String?,
    val isTouchScreen: Boolean?
) {
    class Builder {
        private var brand: String? = null
        private var color: String? = null
        private var isTouchScreen: Boolean? = null

        fun setBrand(brand: String) = apply { this.brand = brand }
        fun setColor(color: String) = apply { this.color = color }
        fun setTouchScreen(isTouchScreen: Boolean) = apply { this.isTouchScreen = isTouchScreen }
        fun build() = Phone(brand, color, isTouchScreen)
    }
}