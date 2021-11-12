package singleton

fun main() {
    println(Singleton.variableName)
}

private object Singleton {
    var variableName = "Hello world"
}