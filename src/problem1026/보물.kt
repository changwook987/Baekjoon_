package problem1026

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val a = StringTokenizer(readLine()).run { List(n) { nextToken().toInt() } }.sorted()
    val b = StringTokenizer(readLine()).run { List(n) { nextToken().toInt() } }.sortedDescending()
    var cnt = 0
    for (i in 0 until n) {
        cnt += a[i] * b[i]
    }
    println(cnt)
}