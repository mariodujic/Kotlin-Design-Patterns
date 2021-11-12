package facade

fun main() {
    with(ShapeFacade()) {
        this.drawRectangle()
        this.drawTriangle()
    }
}

private interface Shape {
    fun draw()
}

private class Triangle: Shape{
    override fun draw() {
        println("Drawing triangle")
    }
}

private class Rectangle: Shape{
    override fun draw() {
        println("Drawing rectangle")
    }
}

private class ShapeFacade {
    private var triangle: Shape = Triangle()
    private var rectangle: Shape =  Rectangle()

    fun drawTriangle() = triangle.draw()
    fun drawRectangle() = rectangle.draw()
}