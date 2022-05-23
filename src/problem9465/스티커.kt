package problem9465

import java.util.*

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        val arr = Array(2) { IntArray(n + 1) }

        repeat(2) {
            with(StringTokenizer(readln())) {
                for (i in 1..n) {
                    arr[it][i] = nextToken().toInt()
                }
            }
        }

        for (i in 1..n) {
            arr[0][i] += if (i >= 2) maxOf(
                arr[1][i - 1], maxOf(
                    arr[0][i - 2], arr[1][i - 2]
                )
            )
            else arr[1][i - 1]

            arr[1][i] += if (i >= 2) maxOf(
                arr[0][i - 1], maxOf(
                    arr[0][i - 2], arr[1][i - 2]
                )
            )
            else arr[0][i - 1]
        }

        println(maxOf(arr[0][n], arr[1][n]))
    }
}