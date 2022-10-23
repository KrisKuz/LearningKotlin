


fun main(args: Array<String>) {
    println("Hello World!")

    val object1 = CarSalesManager()
    val object2 = CarSalesManager()
    val object3 = CarSalesManager()
    val object4 = CarSalesManager()

    val car1 = Car("Lexus")
    object1.garage.cars.add(car1)

    println(object1.garage.cars.get(0).name)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}