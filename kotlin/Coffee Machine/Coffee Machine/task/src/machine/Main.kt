package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var money = 550
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    printState(water, milk, beans, cups, money)
    when (getAction(scanner)) {
        "buy" -> {
            when (selectCoffee(scanner)) {
                1 -> {
                    water -= 250
                    beans -= 16
                    cups -= 1
                    money += 4
                }
                2 -> {
                    water -= 350
                    milk -= 75
                    beans -= 20
                    cups -= 1
                    money += 7
                }
                3 -> {
                    water -= 200
                    milk -= 100
                    beans -= 12
                    cups -= 1
                    money += 6
                }
            }
        }
        "fill" -> {
            water += fillWaterInMachine(scanner)
            milk += fillMilkInMachine(scanner)
            beans += fillCoffeeInMachine(scanner)
            cups += fillCupsInMachine(scanner)
        }
        "take" -> {
            println("I gave you \$$money")
            money = 0
        }
    }

    printState(water, milk, beans, cups, money)
}

fun selectCoffee(scanner: Scanner): Int {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    return scanner.nextInt()
}

fun fillWaterInMachine(scanner: Scanner): Int {
    println("Write how many ml of water do you want to add:")
    return scanner.nextInt()
}

fun fillMilkInMachine(scanner: Scanner): Int {
    println("Write how many ml of milk do you want to add:")
    return scanner.nextInt()
}

fun fillCoffeeInMachine(scanner: Scanner): Int {
    println("Write how many grams of coffee beans do you want to add:")
    return scanner.nextInt()
}

fun fillCupsInMachine(scanner: Scanner): Int {
    println("Write how many disposable cups of coffee do you want to add:")
    return scanner.nextInt()
}

fun getAction(scanner: Scanner): String {
    println("Write action (buy, fill, take): ")
    return scanner.next()
}

private fun printState(water: Int, milk: Int, beans: Int, cups: Int, money: Int) {
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$money of money")
}


