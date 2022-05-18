package problem14500

import java.util.*

fun main() {
    val (n, m) = with(StringTokenizer(readln())) { List(2) { nextToken().toInt() } }
    val graph = List(n) { with(StringTokenizer(readln())) { IntArray(m) { nextToken().toInt() } } }

    data class Pos(val x: Int, val y: Int) {
        operator fun plus(other: Pos): Pos {
            return Pos(
                x + other.x,
                y + other.y
            )
        }
    }

    val yRange = 0 until n
    val xRange = 0 until m

    fun dfs(visited: List<Pos>): Int {
        val pos = visited.last()
        val (x, y) = pos
        if (x !in xRange || y !in yRange) return 0

        if (visited.size == 4) {
            var sum = 0
            for ((i, j) in visited) {
                sum += graph[j][i]
            }
            return sum
        }

        var max = 0
        for (c in visited) {
            listOf(Pos(1, 0), Pos(-1, 0), Pos(0, 1), Pos(0, -1)).forEach {
                if (it + c !in visited) max = maxOf(max, dfs(visited + (it + c)))
            }
        }
        return max
    }

    var max = 0
    for (x in xRange) {
        for (y in yRange) {
            max = maxOf(dfs(listOf(Pos(x, y))), max)
        }
    }
    println(max)
}