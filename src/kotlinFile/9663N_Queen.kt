package kotlinFile

fun main() {
    val n = readln().toInt()

    val map = List(n) { MutableList(n) { 0 } }

    fun check(x: Int, y: Int, inc: Int) {
        for (i in 0 until n) {
            map[i][x] += inc
            map[y][i] += inc
        }

        var cx = x
        var cy = y

        while (cx > 0 && cy > 0) {
            cx--
            cy--
        }

        while (cx < n && cy < n) {
            map[cy++][cx++] += inc
        }

        cx = x
        cy = y

        while (cx != 0 && cy < n - 1) {
            cx--
            cy++
        }

        while (cx < n && cy >= 0) {
            map[cy--][cx++] += inc
        }
    }

    fun solve(index: Int = 0): Int {
        if (index == n) {
            return 1
        }

        var cnt = 0

        for (x in 0 until n) {
            if (map[index][x] != 0) {
                continue
            }

            check(x, index, 1)

            cnt += solve(index + 1)

            check(x, index, -1)
        }

        return cnt
    }

    println(solve())
}