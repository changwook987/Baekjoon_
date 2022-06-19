package problem13023

import java.io.StreamTokenizer
import kotlin.system.exitProcess

val tk = StreamTokenizer(System.`in`.reader())
fun int(): Int {
    tk.nextToken()
    return tk.nval.toInt()
}

fun main() {
    val n = int()
    val m = int()

    val graph = List(n) { ArrayList<Int>() }

    repeat(m) {
        val a = int()
        val b = int()

        graph[a] += b
        graph[b] += a
    }

    val visited = BooleanArray(n)

    fun dfs(cur: Int, dep: Int = 0) {
        visited[cur] = true
        if (dep == 4) {
            println(1)
            exitProcess(0)
        }
        for (i in graph[cur]) {
            if (!visited[i]) {
                dfs(i, dep + 1)
            }
        }

        visited[cur] = false
    }

    repeat(n) { dfs(it) }
    println(0)
}