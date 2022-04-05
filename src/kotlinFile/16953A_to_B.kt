package kotlinFile

import java.util.*

fun main() {
    val (a, b) = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toLong() } }
    val queue: Queue<Pair<Long, Int>> = LinkedList(listOf(a to 1))
    while (queue.isNotEmpty()) {
        val (i, depth) = queue.poll()

        if (i == b) {
            println(depth)
            return
        }

        if (i > b) continue

        queue += i * 10 + 1 to depth + 1
        queue += i * 2 to depth + 1
    }
    println(-1)
}