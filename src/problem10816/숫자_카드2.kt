package problem10816

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }

    val items = read().groupingBy { it }.eachCount()
    val cards = read()
    val w = BufferedWriter(OutputStreamWriter(System.out))

    for (i in cards) {
        w.write((items[i] ?: 0).toString() + " ")
    }
    w.flush()
}