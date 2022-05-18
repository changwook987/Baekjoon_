package problem1992

fun main() {
    val n = readln().toInt()
    val map = List(n) { with(readln()) { IntArray(n) { get(it).digitToInt() } } }

    fun solve(x: Int = 0, y: Int = 0, size: Int = n): String {
        if (size == 1) {
            return map[y][x].toString()
        } else {
            val s = size / 2

            val p1 = solve(x, y, s)
            val p2 = solve(x + s, y, s)
            val p3 = solve(x, y + s, s)
            val p4 = solve(x + s, y + s, s)

            return if (p1.length == 1 && p1 == p2 && p2 == p3 && p3 == p4) {
                p1
            } else {
                "($p1$p2$p3$p4)"
            }
        }
    }

    println(solve())
}
//8
//00000000
//00000000
//00111100
//00111100
//00111100
//00111100
//00000000
//00000000
