package problem1912

import java.util.*
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val list = StringTokenizer(readln()).run { List(n) { nextToken().toInt() } }
    fun dp(list: List<Int>): Int {
        val cache = Array(list.size) { 0 }
        cache[0] = list[0]

        for (i in 1 until list.size) {
            cache[i] = max(0, (cache[i - 1])) + list[i]
        }

        return cache.maxOf { it }
    }
    println(dp(list))
}

