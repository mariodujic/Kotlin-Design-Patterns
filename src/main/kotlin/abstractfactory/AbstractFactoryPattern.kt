package abstractfactory

interface Fruit {
    fun create()
}

class YellowApple() : Fruit {
    override fun create() {
        println("Creating yellow apple!")
    }
}

class GreenApple() : Fruit {
    override fun create() {
        println("Creating green apple!")
    }
}

class BigOrange() : Fruit {
    override fun create() {
        println("Creating big orange!")
    }
}

class SmallOrange() : Fruit {
    override fun create() {
        println("Creating small orange!")
    }
}

interface Type
interface Factory {
    fun getFruit(type: Type): Fruit
}

class AppleFactory : Factory {

    override fun getFruit(type: Type): Fruit = when (type) {
        AppleType.YELLOW_APPLE -> YellowApple()
        AppleType.GREEN_APPLE -> GreenApple()
        else -> throw IllegalArgumentException()
    }

    enum class AppleType : Type {
        YELLOW_APPLE,
        GREEN_APPLE
    }
}

class OrangeFactory : Factory {

    override fun getFruit(type: Type) =
        when (type) {
            OrangeType.BIG_ORANGE -> BigOrange()
            OrangeType.SMALL_ORANGE -> SmallOrange()
            else -> throw IllegalArgumentException()
        }

    enum class OrangeType : Type {
        BIG_ORANGE,
        SMALL_ORANGE
    }
}

class FruitFactory {
    companion object {
        inline fun <reified T> getFactory(): Factory =
            when (T::class) {
                OrangeFactory::class -> OrangeFactory()
                AppleFactory::class -> AppleFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

fun main() {
    val appleFactory: Factory = FruitFactory.getFactory<AppleFactory>()

    val yellowApple = appleFactory.getFruit(AppleFactory.AppleType.YELLOW_APPLE)
    val greenApple = appleFactory.getFruit(AppleFactory.AppleType.GREEN_APPLE)

    yellowApple.create()
    greenApple.create()

    val orangeFactory: Factory = FruitFactory.getFactory<OrangeFactory>()

    val bigOrange = orangeFactory.getFruit(OrangeFactory.OrangeType.BIG_ORANGE)
    val smallOrange = orangeFactory.getFruit(OrangeFactory.OrangeType.SMALL_ORANGE)

    bigOrange.create()
    smallOrange.create()
}