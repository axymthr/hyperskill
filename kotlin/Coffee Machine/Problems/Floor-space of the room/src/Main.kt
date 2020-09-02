import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // write your code here
    when (scanner.next()) {
        "triangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()
            val c = scanner.nextDouble()
            val p = (a + b + c) / 2
            val area = sqrt(p * (p - a) * (p - b) * (p - c))
            println(area)
        }
        "rectangle" -> {
            val a = scanner.nextDouble()
            val b = scanner.nextDouble()

            println(a * b)
        }
        "circle" -> {
            val r = scanner.nextDouble()
            val area = 3.14 * r * r
            println(area)
        }
    }
}
