package kotlinFile

fun main() {
    val n = readln().toInt()
    val graph = List(n) {
        with(readln()) {
            IntArray(n) {
                when (get(it)) {
                    'R' -> 1
                    'G' -> 2
                    else -> 0
                }
            }
        }
    }

    fun check(check: (Int) -> Boolean): Int {
        val visited = BooleanArray(n * n)
        fun dfs(x: Int, y: Int): Boolean {
            if (x in 0 until n && y in 0 until n) {
                if (!visited[y * n + x] && check(graph[y][x])) {
                    visited[y * n + x] = true

                    dfs(x + 1, y)
                    dfs(x - 1, y)
                    dfs(x, y + 1)
                    dfs(x, y - 1)
                    return true
                }
            }
            return false
        }

        var cnt = 0
        repeat(n) { i ->
            repeat(n) { j ->
                if (dfs(i, j)) cnt++
            }
        }
        return cnt
    }

    val rg = check { it > 0 }
    val b = check { it == 0 }
    val r = check { it == 1 }
    val g = check { it == 2 }
    println("${r + g + b} ${rg + b}")
}