package visitor

sealed class Area {
    class Square(val side: Float) : Area()
    class Circle(val radius: Float) : Area()
    class Rectangle(val height: Float, val width: Float) : Area()
}

class AreaVisitor {

    fun getArea(area: Area) = when (area) {
        is Area.Square -> area.side * 4
        is Area.Circle -> 2 * Math.PI * area.radius
        is Area.Rectangle -> (2 * area.height + 2 * area.width)
    }
}

fun main() {

    val square = Area.Square(20.0f)
    val circle = Area.Circle(15.0f)
    val rectangle = Area.Rectangle(5.0f, 10.0f)

    val producer = AreaVisitor()

    println(producer.getArea(square))
    println(producer.getArea(circle))
    println(producer.getArea(rectangle))
}