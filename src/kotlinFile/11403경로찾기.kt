package kotlinFile

import java.util.*

fun main() {
    val n = readln().toInt()
    val graph = List(n) { with(StringTokenizer(readln())) { IntArray(n) { nextToken().toInt() } } }

    fun solve(start: Int, visited: BooleanArray = BooleanArray(n)): BooleanArray {
        for ((idx, value) in graph[start].withIndex()) {
            if (value == 0 || visited[idx]) continue
            //println("($start, $idx): $value")
            graph[start][idx] = 1
            visited[idx] = true
            solve(idx, visited)
        }
        return visited
    }

    for (i in 0 until n) println(solve(i).joinToString(" ") { if (it) "1" else "0" })
}