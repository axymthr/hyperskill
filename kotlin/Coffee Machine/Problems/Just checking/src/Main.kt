import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    val input = scanner.nextInt()
    println(when (input) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })
}