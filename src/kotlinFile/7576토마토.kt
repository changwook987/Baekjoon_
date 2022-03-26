package kotlinFile

import java.util.*

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val (n, m) = read()

    val xRange = 0 until n
    val yRange = 0 until m

    data class Pos(val x: Int, val y: Int)

    val tomatoes = ArrayList<Pos>()

    val map = List(m) { y ->
        with(read()) {
            IntArray(n) { x ->
                get(x).apply {
                    if (this == 1) {
                        tomatoes += Pos(x, y)
                    }
                }
            }
        }
    }

    fun bfs(list: List<Pos>, level: Int = -1): Int {
        if (list.isEmpty()) return level

        val next = ArrayList<Pos>()

        for ((x, y) in list) {
            listOf(
                Pos(x + 1, y), Pos(x - 1, y), Pos(x, y + 1), Pos(x, y - 1)
            ).forEach { (x, y) ->
                if (x in xRange && y in yRange) {
                    if (map[y][x] == 0) {
                        map[y][x] = 1
                        next += Pos(x, y)
                    }
                }
            }
        }

        return bfs(next, level + 1)
    }

    fun hasUnripeTomato(): Boolean {
        for (arr in map) {
            if (arr.find { it == 0 } != null) return true
        }
        return false
    }

    val times = bfs(tomatoes)
    if (hasUnripeTomato()) println(-1)
    else println(times)
}