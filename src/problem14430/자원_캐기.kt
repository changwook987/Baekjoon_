package problem14430

fun main() {
    fun read() = readln().split(" ").run { List(size) { get(it).toInt() } }
    val (n, m) = read()
    val graph = List(n) { read().run { IntArray(m) { get(it) } } }

    val yRange = 0 until n
    val xRange = 0 until m

    fun solve(x: Int = 0, y: Int = 0, cnt: Int = 0): Int {
        if (x == m - 1 && y == n - 1) {
            return cnt
        } else {
            val cur = graph[y][x]
            var c = 0

            if (x + 1 in xRange) {
                c = solve(x + 1, y, cnt + if (cur == 1) 1 else 0)
            }

            if (y + 1 in yRange) {
                solve(x, y + 1, cnt + if (cur == 1) 1 else 0).let {
                    if (c < it) {
                        c = it
                    }
                }
            }
            return c
        }
    }

    println(solve())
}