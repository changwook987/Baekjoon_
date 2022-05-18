package problem11279

import java.util.*

fun main() {
    val queue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
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