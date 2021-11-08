package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val items = read().groupingBy { it }.eachCount()
    val cards = read()
    val w = BufferedWriter(OutputStreamWriter(System.out))

    for (i in cards) {
        w.write((items[i] ?: 0).toString() + " ")
    }
    w.flush()
}

fun read(): List<Int> {
    val n = readLine()!!.toInt()
    val token = StringTokenizer(readLine())
    return List(n) { token.nextToken().toInt() }
}