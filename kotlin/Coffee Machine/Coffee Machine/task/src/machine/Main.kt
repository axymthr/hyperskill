package machine

import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    var money = 550
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9

    fun makeCoffee(useWater: Int, useMilk: Int, useBeans: Int, addMoney: Int) {
        if (!enough(water, useWater, "water") ||
                !enough(milk, useMilk, "milk") ||
                !enough(beans, useBeans, "coffee beans") ||
                !enough(cups, 1, "disposable cups"))
            return
        println("I have enough resources, making you a coffee!")
        water -= useWater//50
        milk -= useMilk//540 - 75
        beans -= useBeans//100
        cups -= 1
        money += addMoney
    }

    fun fillMachine() {
        println("Write how many ml of water do you want to add:")
        water += scanner.nextInt()
        println("Write how many ml of milk do you want to add:")
        milk += scanner.nextInt()
        println("Write how many grams of coffee beans do you want to add:")
        beans += scanner.nextInt()
        println("Write how many disposable cups of coffee do you want to add:")
        cups += scanner.nextInt()
    }

    fun emptyMoney() {
        println("I gave you \$$money")
        money = 0
    }

    fun printState() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
    }

    do {
        val action = getAction(scanner)
        println(action)
        when (action) {
            "buy" -> {
                val coffee = selectCoffee(scanner)
                println(coffee)
                when (coffee) {
                    "1" -> makeCoffee(250, 0, 16, 4)
                    "2" -> makeCoffee(350, 75, 20, 7)
                    "3" -> makeCoffee(200, 100, 12, 6)
                    "back" -> {
                    }
                }
            }
            "fill" -> fillMachine()
            "take" -> emptyMoney()
            "remaining" -> printState()
            "exit" -> {
            }
        }
    } while (action != "exit")
}

fun enough(avail: Int, use: Int, res: String): Boolean {
    if (avail < use) {
        println("Sorry, not enough $res!")
        return false
    }
    return true
}

fun selectCoffee(scanner: Scanner): String {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    return scanner.next()
}

fun getAction(scanner: Scanner): String {
    println("Write action (buy, fill, take, remaining, exit): ")
    return scanner.next()
}



