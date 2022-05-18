package problem1916

import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    fun read() = StringTokenizer(readln()).run { List(countTokens()) { nextToken().toInt() } }
    val graph = List<ArrayList<Pair<Int, Int>>>(n) { ArrayList() }

    repeat(m) {
        val (s, e, c) = read()
        graph[s - 1] += (e - 1) to c
    }

    val (start, end) = read()

    val dist = IntArray(n) { Int.MAX_VALUE }
    dist[start - 1] = 0

    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    priorityQueue += (start - 1) to 0

    while (priorityQueue.isNotEmpty()) {
        val (v, cost) = priorityQueue.poll()

        if (dist[v] < cost) continue

        for ((there, nextCost) in graph[v]) {
            val newValue = cost + nextCost

            if (dist[there] > newValue) {
                dist[there] = newValue
                priorityQueue += there to newValue
            }
        }
    }

    println(dist[end - 1])
}