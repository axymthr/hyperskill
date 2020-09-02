package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val coffeeMachine = CoffeeMachine()
    do {
        println(coffeeMachine.prompt())
        val action = scanner.next()
        coffeeMachine.action(action)
    } while (action != "exit")
}

class CoffeeMachine {
    var money = 550
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var menuState = CoffeeMachineMenuState.MAIN

    fun prompt(): String {
        return when (menuState) {
            CoffeeMachineMenuState.BUY -> {
                println("Prompt BUY")
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
            }
            CoffeeMachineMenuState.FILL_WATER -> "Write how many ml of water do you want to add:"
            CoffeeMachineMenuState.FILL_MILK -> "Write how many ml of milk do you want to add:"
            CoffeeMachineMenuState.FILL_BEANS -> "Write how many grams of coffee beans do you want to add:"
            CoffeeMachineMenuState.FILL_CUPS -> "Write how many disposable cups of coffee do you want to add:"
            else -> {
                menuState == CoffeeMachineMenuState.FILL_WATER
                "Write action (buy, fill, take, remaining, exit): "
            }
        }
    }

    fun action(action: String) {
        when {
            menuState == CoffeeMachineMenuState.MAIN && action == "buy" -> {
                menuState = CoffeeMachineMenuState.BUY
            }

            menuState == CoffeeMachineMenuState.MAIN && action == "fill" -> {
                menuState = CoffeeMachineMenuState.FILL_WATER
            }

            menuState == CoffeeMachineMenuState.MAIN && action == "take" -> emptyMoney()

            menuState == CoffeeMachineMenuState.MAIN && action == "remaining" -> printState()

            menuState == CoffeeMachineMenuState.FILL_WATER -> {
                water += action.toInt()
                menuState = CoffeeMachineMenuState.FILL_MILK
            }

            menuState == CoffeeMachineMenuState.FILL_MILK -> {
                milk += action.toInt()
                menuState = CoffeeMachineMenuState.FILL_BEANS
            }

            menuState == CoffeeMachineMenuState.FILL_BEANS -> {
                beans += action.toInt()
                menuState = CoffeeMachineMenuState.FILL_CUPS
            }

            menuState == CoffeeMachineMenuState.FILL_CUPS -> {
                cups += action.toInt()
                menuState = CoffeeMachineMenuState.MAIN
            }

            menuState == CoffeeMachineMenuState.BUY -> {
                when (action) {
                    "1" -> makeCoffee(250, 0, 16, 4)
                    "2" -> makeCoffee(350, 75, 20, 7)
                    "3" -> makeCoffee(200, 100, 12, 6)
                    else -> {
                    }
                }
                menuState = CoffeeMachineMenuState.MAIN
            }

            else -> {
            }
        }
    }

    private fun printState() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$beans of coffee beans")
        println("$cups of disposable cups")
        println("$money of money")
    }

    private fun makeCoffee(useWater: Int, useMilk: Int, useBeans: Int, addMoney: Int) {
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

    private fun emptyMoney() {
        println("I gave you \$$money")
        money = 0
    }
}

enum class CoffeeMachineMenuState {
    MAIN,
    BUY,
    FILL_WATER,
    FILL_MILK,
    FILL_BEANS,
    FILL_CUPS,
}

fun enough(avail: Int, use: Int, res: String): Boolean {
    if (avail < use) {
        println("Sorry, not enough $res!")
        return false
    }
    return true
}





