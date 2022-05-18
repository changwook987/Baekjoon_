package problem1107

import java.util.*
import kotlin.math.absoluteValue

fun main() = with(Scanner(System.`in`)) {
    val goal = nextInt()
    val wrongBtn = List(nextInt()) { nextInt() }

    fun Int.length(): Int = toString().length

    fun Int.step() = length() + (goal - this).absoluteValue

    var leastStep = 100.step() - 3

    repeat(1_000_000) { i ->
        run checking@{
            val n = "$i"

            for (c in n) {
                if (c.digitToInt() in wrongBtn) {
                    return@checking
                }
            }

            leastStep = minOf(leastStep, i.step())
        }
    }

    println(leastStep)
}