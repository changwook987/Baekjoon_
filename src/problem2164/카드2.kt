package problem2164

import java.util.*

fun main() {
    val n = readLine()!!.toInt()

    val queue: Queue<Int> = LinkedList()

    queue.addAll(List(n) { it + 1 })

    while (queue.size != 1) {
        with(queue) {
            poll()
            add(poll())
        }
    }

    println(queue.peek())
}