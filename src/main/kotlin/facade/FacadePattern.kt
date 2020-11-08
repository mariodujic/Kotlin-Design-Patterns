package facade

interface Shape {
    fun draw()
}

class Triangle: Shape{
    override fun draw() {
        println("Drawing triangle")
    }
}

class Rectangle: Shape{
    override fun draw() {
        println("Drawing rectangle")
    }
}

class ShapeFacade {
    private var triangle: Shape = Triangle()
    private var rectangle: Shape =  Rectangle()

    fun drawTriangle() = triangle.draw()
    fun drawRectangle() = rectangle.draw()
}

fun main() {
    with(ShapeFacade()) {
        this.drawRectangle()
        this.drawTriangle()
    }
}