package problem11375

import java.io.StreamTokenizer

val tokenizer = StreamTokenizer(System.`in`.reader())

fun nextInt(): Int {
    tokenizer.nextToken()
    return tokenizer.nval.toInt()
}

fun main() {
    val n = nextInt()
    val m = nextInt()

    val graph = List(n + 1) { ArrayList<Int>() }

    repeat(n) { i ->
        repeat(nextInt()) {
            graph[i + 1] += nextInt()
        }
    }

    val visited = BooleanArray(m + 1)
    val d = IntArray(m + 1)

    fun dfs(cur: Int): Boolean {

        for (t in graph[cur]) {
            if (visited[t]) continue

            visited[t] = true

            if (d[t] == 0 || dfs(d[t])) {
                d[t] = cur
                return true
            }
        }

        return false
    }

    var cnt = 0

    for (i in 1..n) {
        visited.fill(false)
        if (dfs(i)) cnt++
    }

    println(cnt)
}