package problem1260

import java.util.*

fun main() {
    fun r() = readln().split(" ").map { it.toInt() - 1 }
    var (v, e, s) = r()
    v++
    e++
    val graph = List<SortedSet<Int>>(v) { TreeSet() }

    repeat(e) {
        val (a, b) = r()

        graph[a] += b
        graph[b] += a
    }

    var visited = BooleanArray(v)

    fun dfs(cur: Int) {
        print("${cur + 1} ")
        visited[cur] = true
        for (i in graph[cur]) {
            if (visited[i]) continue
            dfs(i)
        }
    }

    fun bfs(cur: Int) {
        val queue: Queue<Int> = LinkedList()
        val sb = StringBuilder()
        queue += cur

        while (queue.isNotEmpty()) {
            val c = queue.poll()

            if (visited[c]) continue
            visited[c] = true
            queue += graph[c]
            sb.append("${c + 1} ")
        }

        println(sb)
    }

    dfs(s)
    println()
    visited = BooleanArray(v)
    bfs(s)
}