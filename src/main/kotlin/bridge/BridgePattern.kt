package bridge

interface Content {
    fun start()
}

interface Device {
    var content: Content
    fun playContent()
}

class Computer(override var content: Content) : Device {

    override fun playContent() {
        content.start()
    }
}

class VideoStream: Content {
    override fun start() {
        println("Playing video stream!")
    }
}

class Music: Content {
    override fun start() {
        println("Playing music!")
    }
}

fun main() {

    val videoStreamContent: Content = VideoStream()
    val musicContent: Content = Music()

    val computerDevice = Computer(videoStreamContent)
    computerDevice.playContent()

    computerDevice.content = musicContent
    computerDevice.playContent()
}
