package problem1927

import java.util.*

fun main() {
    val queue = PriorityQueue<Int>()
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