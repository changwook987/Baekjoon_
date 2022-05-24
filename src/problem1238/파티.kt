package problem1238

import java.util.*

val r = System.`in`.bufferedReader()
fun read() = r.readLine().split(" ").map { it.toInt() }

fun main() {
    val (n, m, x) = read()
    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }

    repeat(m) {
        val (a, b, c) = read()
        graph[a] += b to c
    }

    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    fun dijkstra(start: Int): IntArray {
        val array = IntArray(n + 1) { Int.MAX_VALUE }
        pq += start to 0

        while (pq.isNotEmpty()) {
            val (end, cost) = pq.poll()
            if (array[end] < cost) continue

            array[end] = cost

            for ((e, c) in graph[end]) {
                pq += e to c + cost
            }
        }

        return array
    }

    val dij = dijkstra(x)
    val arr = IntArray(n + 1) { dijkstra(it)[x] + dij[it] }

    println(arr.drop(1).maxOf { it })
}