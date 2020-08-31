package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Write how many ml of water the coffee machine has:")
    val actlWater = scanner.nextInt() //1550
    println("Write how many ml of milk the coffee machine has:")
    val actlMilk = scanner.nextInt() //299
    println("Write how many grams of coffee beans the coffee machine has:")
    val actlCoffee = scanner.nextInt() //300
    println("Write how many cups of coffee you will need:")
    val cups = scanner.nextInt() //3
    val water = 200
    val milk = 50
    val beans = 15
    val waterUnits = actlWater / water //300 / 200 = 1
    val milkUnits = actlMilk / milk //65 / 50 = 1
    val coffeeUnits = actlCoffee / beans // 111 / 15 = 7
    var actual = if (waterUnits > milkUnits) milkUnits else waterUnits //
    actual = if (coffeeUnits > actual) actual else coffeeUnits

    when {
        cups == actual -> {
            println("Yes, I can make that amount of coffee")
        }
        cups > actual -> {
            println("No, I can make only $actual cups of coffee")
        }
        else -> {
            println("Yes, I can make that amount of coffee (and even ${actual - cups} more than that)")
        }
    }
}


