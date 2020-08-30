package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Write how many cups of coffee you will need:")
    val cups = scanner.nextInt()
    println("For $cups cups of coffee you will need:")
    val water = 200*cups
    println("$water ml of water")
    val milk = 50*cups
    println("$milk ml of milk")
    val beans = 15*cups
    println("$beans g of coffee beans")
}
