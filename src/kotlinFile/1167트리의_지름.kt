package kotlinFile

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val size = r.readLine().toInt()

    val graph = List(size) { ArrayList<Pair<Int, Int>>() }

    repeat(size) {
        with(StringTokenizer(r.readLine())) {
            val p = nextToken().toInt() - 1

            repeat(countTokens() / 2) {
                val c = nextToken().toInt() - 1
                val d = nextToken().toInt()

                graph[p] += c to d
            }
        }
    }

    val visited = BooleanArray(size)

    fun dfs(cur: Int, dist: Int): Pair<Int, Int> {
        var max = 0
        var last = 0

        visited[cur] = true

        for ((i, d) in graph[cur]) {
            if (visited[i]) continue

            val (value, l) = dfs(i, dist + d)

            if (max < value) {
                max = value
                last = l
            }
        }

        visited[cur] = false

        return if (max == 0) {
            dist to cur
        } else max to last
    }

    println(dfs(dfs(0, 0).second, 0).first)
}