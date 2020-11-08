package factory

interface Shape {
    fun draw()
}

class Triangle : Shape {
    override fun draw() {
        println("Drawing triangle")
    }
}


class Rectangle : Shape {
    override fun draw() {
        println("Drawing rectangle")
    }
}

enum class ShapeType {
    TRIANGLE,
    RECTANGLE
}

class ShapeFactory {

    fun getShape(type: ShapeType): Shape {
        return when (type) {
            ShapeType.TRIANGLE -> Triangle()
            ShapeType.RECTANGLE -> Rectangle()
        }
    }
}

fun main() {

    val shapeFactory = ShapeFactory()
    val triangleShape: Shape = shapeFactory.getShape(ShapeType.TRIANGLE)
    triangleShape.draw()

    val rectangleShape: Shape = shapeFactory.getShape(ShapeType.RECTANGLE)
    rectangleShape.draw()
}