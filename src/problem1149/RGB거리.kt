package problem1149

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = Array(n + 1) { IntArray(3) }

    repeat(n) {
        val y = it + 1
        with(StringTokenizer(readln())) {
            repeat(3) { x ->
                arr[y][x] = nextToken().toInt() + kotlin.run {
                    var min = Int.MAX_VALUE

                    repeat(3) { x1 ->
                        if (x1 != x) {
                            min = minOf(arr[y - 1][x1], min)
                        }
                    }

                    min
                }
            }
        }
    }

    println(arr[n].minOf { it })
}