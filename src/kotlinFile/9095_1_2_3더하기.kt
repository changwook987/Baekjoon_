package kotlinFile

fun main() {
    val ways = mapOf(0 to 1, 1 to 1).toMutableMap()

    fun solve(n: Int): Int {
        if (!ways.contains(n)) {
            var cnt = 0

            if (n >= 3) {
                cnt += solve(n.minus(3))
            }
            if (n >= 2) {
                cnt += solve(n.minus(2))
            }
            cnt += solve(n.minus(1))

            ways[n] = cnt
        }
        return ways[n]!!
    }
    for (i in MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }) {
        println(solve(i))
    }
}


