package signature

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val name = scanner.nextLine()
    val len = name.length
    printRepeat(len)
    println()
    print("* ")
    print(name)
    println(" *")
    printRepeat(len)
}

fun printRepeat(len: Int) {
    repeat(len+4) {
        print("*")
    }
}