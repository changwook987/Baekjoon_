package problem1753

import java.util.*

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val (v, e) = read()

    val first = readln().toInt() - 1

    data class Node(val end: Int, val cost: Int)

    val graph = List<ArrayList<Node>>(v) { ArrayList() }

    repeat(e) {
        val (start, end, cost) = read()
        graph[start - 1] += Node(end - 1, cost)
    }

    val visited = Array(v) { false }
    val dist = Array(v) { if (it == first) 0 else Int.MAX_VALUE }

    repeat(v) {
        val leastIdx = run {
            var min = Int.MAX_VALUE
            var idx = 0

            for (j in 0 until v) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j]
                    idx = j
                }
            }

            visited[idx] = true
            idx
        }

        for (adjNode in graph[leastIdx]) {
            val newDist = (dist[leastIdx]) + adjNode.cost
            if (dist[adjNode.end] > newDist) {
                dist[adjNode.end] = newDist
            }
        }
    }

    println(dist.joinToString("\n") { if (it == Int.MAX_VALUE) "INF" else it.toString() })
}
