package kotlinFile

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    fun read() = with(StringTokenizer(r.readLine())) { List(countTokens()) { nextToken().toInt() } }
    val (n, m) = read()
    val arr = IntArray(n + 1)

    with(read()) {
        for (i in 1..n) {
            arr[i] = arr[i - 1] + get(i - 1)
        }
    }

    System.out.bufferedWriter().use { w ->
        repeat(m) {
            val (a, b) = read()
            w.appendLine("${arr[b] - arr[a - 1]}")
        }
        w.flush()
    }
}