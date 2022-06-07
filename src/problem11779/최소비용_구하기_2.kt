package problem11779

import java.util.*

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val graph = Array(n + 1) { ArrayList<Pair<Int, Int>>() }

    repeat(m) {
        val (s, e, c) = readln().split(" ").map { it.toInt() }
        graph[s] += e to c
    }

    val (s, e) = readln().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }

    fun dijkstra(start: Int): IntArray {
        val dist = IntArray(n + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq += start to 0
        dist[start] = 0

        while (pq.isNotEmpty()) {
            val (cur, distance) = pq.poll()
            if (distance > dist[cur]) continue

            for ((i, c) in graph[cur]) {
                val newDist = distance + c

                if (dist[i] > newDist) {
                    dist[i] = newDist
                    pq += i to newDist
                    parent[i] = cur
                }
            }
        }
        return dist
    }

    val dij = dijkstra(s)
    var size = 1
    val route = with(StringBuilder()) {
        var cur = e
        while (cur != parent[cur]) {
            size++
            insert(0, "$cur ")
            cur = parent[cur]
        }
        insert(0, "$cur ")
        trim()
    }

    println(dij[e])
    println(size)
    println(route)
}
/*
3
3
1 2 0
2 3 1
1 3 0
1 3
*/