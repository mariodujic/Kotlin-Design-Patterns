package command

fun main() {
    val commandProcess = CommandProcess()
    commandProcess
        .addToQueue(OrderAddCommand("1"))
        .addToQueue(OrderPayCommand("1"))
        .processCommands()

}

interface OrderCommand {
    fun execute()
}

class OrderAddCommand(private val id: String) : OrderCommand {
    override fun execute() = println("Adding order with the id $id")
}

class OrderPayCommand(private val id: String) : OrderCommand {
    override fun execute() = println("Paying order with the id $id")
}

class CommandProcess {
    private val queue = ArrayList<OrderCommand>()

    fun addToQueue(orderCommand: OrderCommand) = apply { queue.add(orderCommand) }
    fun processCommands() = apply {
        queue.forEach { it.execute() }.also { queue.clear() }
    }
}