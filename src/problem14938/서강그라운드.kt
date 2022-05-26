package problem14938

import java.util.*

fun read() = readln().split(" ").map { it.toInt() }

fun main() {
    val (n, m, r) = read()

    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
    val values = read()

    repeat(r) {
        val (a, b, c) = read()

        graph[a] += b to c
        graph[b] += a to c
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    fun dijkstra(start: Int): IntArray {
        val arr = IntArray(n + 1) { Int.MAX_VALUE }
        pq += start to 0

        while (pq.isNotEmpty()) {
            val (end, cost) = pq.poll()

            if (arr[end] <= cost) continue
            arr[end] = cost

            for ((e, c) in graph[end]) {
                pq += e to cost + c
            }
        }

        return arr
    }

    (1..n).maxOf { i ->
        val arr = dijkstra(i)
        var tot = 0

        for (j in 1..n) {
            if (arr[j] <= m) {
                tot += values[j - 1]
            }
        }

        tot
    }.let {
        println(it)
    }
}