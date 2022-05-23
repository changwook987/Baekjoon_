package problem1932

import java.util.*

fun main() {
    val n = readln().toInt()
    val map = Array(n + 1) { i -> IntArray(i + 2) }

    repeat(n) { i ->
        with(StringTokenizer(readln())) {
            repeat(i + 1) { j ->
                map[i + 1][j + 1] =
                    nextToken().toInt() + maxOf(map[i][j], map[i][j + 1])
            }
        }
    }

    println(map[n].maxOf { it })
}