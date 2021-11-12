package factory

fun main() {

    val shapeFactory = ShapeFactory()
    val triangleShape: Shape = shapeFactory.getShape(ShapeType.TRIANGLE)
    triangleShape.draw()

    val rectangleShape: Shape = shapeFactory.getShape(ShapeType.RECTANGLE)
    rectangleShape.draw()
}

private interface Shape {
    fun draw()
}

private class Triangle : Shape {
    override fun draw() {
        println("Drawing triangle")
    }
}


private class Rectangle : Shape {
    override fun draw() {
        println("Drawing rectangle")
    }
}

private enum class ShapeType {
    TRIANGLE,
    RECTANGLE
}

private class ShapeFactory {

    fun getShape(type: ShapeType): Shape {
        return when (type) {
            ShapeType.TRIANGLE -> Triangle()
            ShapeType.RECTANGLE -> Rectangle()
        }
    }
}