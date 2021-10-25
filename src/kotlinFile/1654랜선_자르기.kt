package kotlinFile

import java.util.*

fun main() {
    val token = StringTokenizer(readLine())
    val lan = MutableList(token.nextToken().toInt()) { readLine()!!.toLong() }
    val amount = token.nextToken().toInt()

    var left = 0L
    var right = lan.maxOf { it }

    while (left <= right) {
        val mid = left.plus(right).div(2).coerceAtLeast(1L)
        var cnt = 0L

        lan.forEach { cnt += it.div(mid) }

        if (cnt < amount) {
            right = mid.minus(1)
        } else {
            left = mid.plus(1)
        }
    }
    println(right)
}