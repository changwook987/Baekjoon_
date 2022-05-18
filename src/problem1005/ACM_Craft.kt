package problem1005

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()

    fun r() = r.readLine().split(" ").map { it.toInt() }

    val t = r.readLine().toInt()

    repeat(t) {
        val (vertex, edge) = r()
        val time = listOf(0) + r()
        val graph = List(vertex + 1) { ArrayList<Int>() } // parent graph

        repeat(edge) {
            val (s, e) = r()
            graph[e] += s
        }

        val map = TreeMap<Int, Int>()

        fun dfs(cur: Int): Int {
            return map.getOrPut(cur) {
                if (graph.isEmpty()) time[cur]
                else {
                    var m = 0
                    for (p in graph[cur]) {
                        m = maxOf(m, dfs(p))
                    }
                    m + time[cur]
                }
            }
        }

        val e = r.readLine().toInt()
        w.appendLine("${dfs(e)}")
    }

    w.flush()
}