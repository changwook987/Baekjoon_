package problem1225

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val a = next()
    val b = next()

    var result = 0L

    for (i in a) {
        for (j in b) {
            result += i.digitToInt() * j.digitToInt()
        }
    }

    println(result)
}