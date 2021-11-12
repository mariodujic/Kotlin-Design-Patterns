package observer

fun main() {
    val subject: Subject = Subject().also {
        GameObserver(it)
    }
    subject.message = "Game started"
    subject.message = "Game finished"
}

private class Subject {
    private val observers = mutableListOf<Observer>()

    var message: String = ""
        set(value) {
            field = value
            notifyAllObservers()
        }

    private fun notifyAllObservers() {
        observers.forEach {
            it.update()
        }
    }

    fun attachObserver(observer: Observer) = observers.add(observer)
}

private interface Observer {
    fun update()
}

private class GameObserver(private val subject: Subject) : Observer {

    init {
        subject.attachObserver(this)
    }

    override fun update() {
        println("Game message: ${subject.message}")
    }
}