package mediator

class Process {
    fun startWork(clientType: String) {
        println("Processing $clientType data")
    }
}

data class Device(
    private val process: Process
) {
    fun start() {
        process.startWork("device")
    }
}

fun main() {
    val process = Process()
    with(Device(process)) {
        start()
    }
}