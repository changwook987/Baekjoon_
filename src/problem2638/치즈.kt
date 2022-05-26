package problem2638

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = List(n) { readln().split(" ").map { it.toInt() * 4 }.toIntArray() }

    val rX = 0 until m
    val rY = 0 until n

    fun dfs() {
        val visited = Array(n) { BooleanArray(m) }
        fun solve(x: Int, y: Int) {
            if (visited[y][x]) return

            if (graph[y][x] > 0) {
                graph[y][x]--
            } else {
                visited[y][x] = true

                if (x + 1 in rX) solve(x + 1, y)
                if (x - 1 in rX) solve(x - 1, y)
                if (y + 1 in rY) solve(x, y + 1)
                if (y - 1 in rY) solve(x, y - 1)

            }
        }
        solve(0, 0)
    }

    fun check(): Boolean {
        var flag = false

        for (i in rY) {
            for (j in rX) {
                if (graph[i][j] > 2) {
                    flag = true
                    graph[i][j] = 4
                } else {
                    graph[i][j] = 0
                }
            }
        }

        return flag
    }

    var i = 0
    while (check()) {
        dfs()
        i++
    }
    println(i)
}