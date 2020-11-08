package decorator

interface Processor {
    fun process()
}

class HeadphonesProcessor : Processor {
    override fun process() = println("Processing headphones")
}

interface ProcessorDecorator : Processor

class AudioHeadsetDecorator(private val processor: Processor) : ProcessorDecorator {
    override fun process() {
        processor.process()
        startMicrophone()
    }

    private fun startMicrophone() = println("Starting microphone")
}


fun main() {
    val headphonesProcessor: Processor = HeadphonesProcessor()
    val audioHeadsetDecorator: ProcessorDecorator = AudioHeadsetDecorator(headphonesProcessor)
    audioHeadsetDecorator.process()
}