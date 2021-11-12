package decorator


fun main() {
    val headphonesProcessor: Processor = HeadphonesProcessor()
    val audioHeadsetDecorator: ProcessorDecorator = AudioHeadsetDecorator(headphonesProcessor)
    audioHeadsetDecorator.process()
}

private interface Processor {
    fun process()
}

private class HeadphonesProcessor : Processor {
    override fun process() = println("Processing headphones")
}

private interface ProcessorDecorator : Processor

private class AudioHeadsetDecorator(private val processor: Processor) : ProcessorDecorator {
    override fun process() {
        processor.process()
        startMicrophone()
    }

    private fun startMicrophone() = println("Starting microphone")
}