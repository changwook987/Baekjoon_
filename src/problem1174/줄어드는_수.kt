package problem1174

import java.util.*

fun main() {
    val queue: Queue<Long> = LinkedList()
    repeat(10) {
        queue += it.toLong()
    }

    var n = readln().toInt()
    var cur: Long = 0

    while (n-- > 0) {
        if (queue.isEmpty()) {
            println(-1)
            return
        }

        cur = queue.poll()
        val m = cur % 10

        for (i in 0 until m) {
            queue += cur * 10 + i
        }
    }

    println(cur)
}