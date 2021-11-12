package bridge

fun main() {

    val videoStreamContent: Content = VideoStream()
    val musicContent: Content = Music()

    val computerDevice = Computer(videoStreamContent)
    computerDevice.playContent()

    computerDevice.content = musicContent
    computerDevice.playContent()
}


private interface Content {
    fun start()
}

private interface Device {
    var content: Content
    fun playContent()
}

private class Computer(override var content: Content) : Device {

    override fun playContent() {
        content.start()
    }
}

private class VideoStream: Content {
    override fun start() {
        println("Playing video stream!")
    }
}

private class Music: Content {
    override fun start() {
        println("Playing music!")
    }
}