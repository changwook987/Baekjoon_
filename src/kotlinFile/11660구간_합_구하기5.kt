package kotlinFile

import java.util.*

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val (n, m) = read()
    val map = List(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        with(read()) {
            for (j in 1..n) {
                map[i][j] = get(j - 1) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1]
            }
        }
    }

    System.out.bufferedWriter().use { w ->
        repeat(m) {
            val (y1, x1, y2, x2) = read()

            w.appendLine(
                "${map[y2][x2] - map[y1 - 1][x2] - map[y2][x1 - 1] + map[y1 - 1][x1 - 1]}"
            )
        }

        w.flush()
    }
}