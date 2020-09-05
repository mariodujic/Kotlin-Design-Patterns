package composite

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing rectangle")
    }
}

class ShapeComposite {
    private val shapes = mutableListOf<Shape>()

    fun addShape(vararg shape: Shape) = shape.forEach { s -> shapes.add(s) }
    fun useShapes() = shapes.forEach { shape: Shape -> shape.draw() }
}

fun main() {
    val circle: Shape = Circle()
    val rectangle: Shape = Rectangle()

    with(ShapeComposite()) {
        this.addShape(circle, rectangle)
        this.useShapes()
    }
}