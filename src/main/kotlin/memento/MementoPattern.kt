package memento

fun main() {
    val caretaker = Caretaker()
    val originator = Originator()

    originator.let {
        it.setState("a1")
        caretaker.addMemento(it.create())
        it.setState("a2")
        caretaker.addMemento(it.create())

        it.restore(caretaker.getMementoByIndex(0))
        it.restore(caretaker.getMementoByIndex(1))
    }
}

private data class Memento(val state: String)

private class Originator {
    private lateinit var state: String

    fun setState(state: String) {
        this.state = state
    }

    fun create() = Memento(state)
    fun restore(memento: Memento) {
        state = memento.state
        println("New state set in originator $state")
    }
}

private class Caretaker {
    private val mementos = mutableListOf<Memento>()
    fun addMemento(memento: Memento) = mementos.add(memento)
    fun getMementoByIndex(mementoIndex: Int) = mementos[mementoIndex]
}