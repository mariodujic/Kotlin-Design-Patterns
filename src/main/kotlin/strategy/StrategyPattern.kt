package strategy

fun main() {

    val lower = Printer(strategy = lowerCaseFormatter)
    println(lower.print("O tempora, o mores!"))
    val upper = Printer(strategy = upperCaseFormatter)
    println(upper.print("O tempora, o mores!"))
}

private class Printer(private val strategy: (String) -> String) {
    fun print(string: String): String = strategy(string)
}

private val lowerCaseFormatter: (String) -> String = String::toLowerCase
private val upperCaseFormatter: (String) -> String = String::toUpperCase