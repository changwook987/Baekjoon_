package problem11286

import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val queue =
        PriorityQueue<Int> { o1, o2 ->
            val comp = o1.absoluteValue - o2.absoluteValue

            if (comp == 0) {
                o1 - o2
            } else {
                comp
            }
        }

    val n = readLine()!!.toInt()

    repeat(n) {
        val input = readLine()!!.toInt()

        if (input == 0) {
            println(queue.poll() ?: 0)
        } else {
            queue += input
        }
    }
}