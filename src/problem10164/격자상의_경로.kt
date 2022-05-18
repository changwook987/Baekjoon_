package problem10164

fun main() {
    val (n, m, k) = readln().split(' ').run { List(size) { get(it).toInt() } }

    fun dp(x: Int, y: Int): Int {
        if (x == 0 || y == 0) return 1
        val map = List(y) { IntArray(x) }

        val xRange = 0 until x
        val yRange = 0 until y

        fun solve(x: Int = 0, y: Int = 0) {
            map[y][x]++

            if (x + 1 in xRange) {
                solve(x + 1, y)
            }

            if (y + 1 in yRange) {
                solve(x, y + 1)
            }
        }

        solve()
        return map[y - 1][x - 1]
    }

    if (k == 0) {
        println(dp(m, n))
    } else {
        val x = k.dec() % m
        val y = k.dec() / m

        val a = dp(x + 1, y + 1)
        val b = dp(m - x, n - y)

        println(a * b)
    }
}