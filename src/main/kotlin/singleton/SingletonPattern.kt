package singleton

object Singleton {
    var variableName = "Hello"
}

class Test {

    fun testSingleton() {
        println(System.identityHashCode(Singleton.variableName))
        println(Singleton.variableName)
    }
}

fun main() {
    println(Singleton.variableName)
    Singleton.variableName = "World"
    println(System.identityHashCode(Singleton.variableName))
    Test().testSingleton()
}