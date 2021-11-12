package flyweight

fun main() {
    val fordFirst: Vehicle = FordFlyweight(1985)
    val fordSecond: Vehicle = FordFlyweight(1990)
    val fordThird: Vehicle = FordFlyweight(1995)

    with(VehicleFactory()) {
        this.addVehicle(fordFirst, fordSecond, fordThird)
        this.getVehiclesAmount()
        this.getVehicle(1985).start()
        this.getVehiclesAmount()
        this.getVehicle(2005).start()
        this.getVehiclesAmount()
    }
}

private interface Vehicle {
    val year: Int
    fun start()
}

private class FordFlyweight(override val year: Int) : Vehicle {
    override fun start() {
        println("Starting Ford from year $year")
    }
}

private class VehicleFactory() {
    private val vehicles = mutableListOf<Vehicle>()

    fun addVehicle(vararg vehicle: Vehicle) = vehicle.forEach { newVehicle: Vehicle -> vehicles.add(newVehicle) }
    fun getVehicle(year: Int): Vehicle =
        vehicles.find { existingVehicle -> existingVehicle.year == year } ?: FordFlyweight(year).also {
            vehicles.add(it)
        }

    fun getVehiclesAmount() = apply { println("There are ${vehicles.size} vehicles.") }
}