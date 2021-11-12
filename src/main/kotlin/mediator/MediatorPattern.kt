package mediator

fun main() {
    val process = Process()
    with(Device(process)) {
        start()
    }
}

private class Process {
    fun startWork(clientType: String) {
        println("Processing $clientType data")
    }
}

private data class Device(private val process: Process) {
    fun start() {
        process.startWork("device")
    }
}