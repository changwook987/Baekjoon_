package problem2583

import java.io.StreamTokenizer

val tk = StreamTokenizer(System.`in`.reader())
fun int(): Int {
    tk.nextToken()
    return tk.nval.toInt()
}

fun main() {
    val m = int()
    val n = int()
    val k = int()

    val arr = Array(m) { BooleanArray(n) }

    repeat(k) {
        val x1 = int()
        val y1 = int()
        val x2 = int()
        val y2 = int()

        for (x in x1 until x2) {
            for (y in y1 until y2) {
                arr[y][x] = true
            }
        }
    }

    fun dfs(x: Int, y: Int): Int {
        if (arr[y][x]) return 0

        var cnt = 0
        arr[y][x] = true

        if (x - 1 in 0 until n) cnt += dfs(x - 1, y)
        if (x + 1 in 0 until n) cnt += dfs(x + 1, y)
        if (y - 1 in 0 until m) cnt += dfs(x, y - 1)
        if (y + 1 in 0 until m) cnt += dfs(x, y + 1)

        return cnt + 1
    }

    val list = ArrayList<Int>()

    for (y in 0 until m) {
        for (x in 0 until n) {
            dfs(x, y).let {
                if (it != 0) list += it
            }
        }
    }

    println(list.size)
    println(list.sorted().joinToString(" "))
}