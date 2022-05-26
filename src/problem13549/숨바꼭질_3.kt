package problem13549

import java.util.*

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val deque: Deque<Pair<Int, Int>> = LinkedList()
    val map = IntArray(2_000_000) { Int.MAX_VALUE }

    deque += a to 0

    while (deque.isNotEmpty()) {
        val (cur, cost) = deque.pollFirst()

        if (map[cur] < cost) continue
        map[cur] = cost

        if (cur == b) {
            println(cost)
            break
        }

        if (cur != 0 && cur * 2 < 200000) {
            deque.addFirst(cur * 2 to cost)
        }

        if (cur + 1 < 200000) {
            deque.addLast(cur + 1 to cost + 1)
        }

        if (cur - 1 >= 0) {
            deque.addLast(cur - 1 to cost + 1)
        }
    }
}