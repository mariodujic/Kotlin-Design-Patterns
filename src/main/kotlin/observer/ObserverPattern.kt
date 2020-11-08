package observer

class Subject {
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

interface Observer {
    fun update()
}

class GameObserver(private val subject: Subject) : Observer {

    init {
        subject.attachObserver(this)
    }

    override fun update() {
        println("Game message: ${subject.message}")
    }
}

fun main() {
    val subject: Subject = Subject().also {
        GameObserver(it)
    }
    subject.message = "Game started"
    subject.message = "Game finished"
}