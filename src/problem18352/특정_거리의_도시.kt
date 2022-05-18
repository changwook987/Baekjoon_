package problem18352

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()

    fun r() = r.readLine().split(" ").map { it.toInt() }

    val (n, m, k, x) = r()

    val graph = List(n + 1) { ArrayList<Int>() }
    repeat(m) {
        val (p, c) = r()
        graph[p] += c
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    val visited = IntArray(n + 1) { Int.MAX_VALUE }

    queue += x to 0

    while (queue.isNotEmpty()) {
        val (e, d) = queue.poll()
        if (visited[e] < d) continue
        visited[e] =
            d
        queue += graph[e].map { it to (d + 1) }
    }

    var flag = true

    for ((i, v) in visited.withIndex()) {
        if (v == k) {
            flag =
                false
            w.append("$i\n")
        }
    }

    if (flag) w.append("-1")
    w.flush()
}
