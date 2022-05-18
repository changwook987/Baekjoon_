package problem1931

import java.util.*

fun main() {
    data class Time(val start: Int, val end: Int) : Comparable<Time> {
        override fun compareTo(other: Time): Int {
            return if (end == other.end) {
                start - other.start
            } else {
                end - other.end
            }
        }
    }

    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }

    val n = readln().toInt()

    val list = List(n) {
        val (start, end) = read()
        Time(start, end)
    }.sorted()

    var cur = 0
    var cnt = 0

    for ((start, end) in list) {
        if (cur <= start) {
            cur = end
            cnt++
        }
    }

    println(cnt)
}

