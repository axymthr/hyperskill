package search

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val first = scanner.nextLine()
    val sec = scanner.nextLine()
    val words = first.split(" ")
    for (w in words.indices) {
        if (words[w] == sec) {
            println(w+1)
            return
        }
    }
    println("Not found")
}
