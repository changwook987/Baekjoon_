package problem1038

import java.util.*

fun main() {
    var n = readln().toInt()

    if (n == 0) {
        println(0)
        return
    }

    val queue: Queue<Long> = LinkedList()

    for (i in 1 until 10) queue += i.toLong()

    while (queue.isNotEmpty() && n-- > 0) {
        val m = queue.poll()

        if (n == 0) {
            println(m)
            return
        }

        for (i in 0 until m % 10) queue += m * 10 + i
    }

    println(-1)
}