package minesweeper

import java.util.*
import kotlin.random.Random.Default.nextInt


fun main() {
    val scanner = Scanner(System.`in`)
    println("How many mines do you want on the field?")
    val minesCount = scanner.nextInt()
    val minefield = CharArray(81)
    minefield.fill('.')
    var counter = minesCount
    while (counter > 0) {
        val rand = nextInt(1, 82)
        if (minefield[rand-1] == '.') {
            minefield[rand-1] = 'X'
            counter --
        }
    }
    for (i in minefield.indices) {
        print(minefield[i])
        if (i % 9 == 8) println()
    }
}
