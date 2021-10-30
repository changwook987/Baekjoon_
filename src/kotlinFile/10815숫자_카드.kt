package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val r = BufferedReader(InputStreamReader(System.`in`))
private val w = BufferedWriter(OutputStreamWriter(System.out))

private fun read(): List<Int> {
    val n = r.readLine().toInt()
    val token = StringTokenizer(r.readLine())

    return MutableList(n) { token.nextToken().toInt() }
}

fun main() {
    val list = read().sorted()
    val find = read()

    for (f in find) {
        w.write((if (list.binarySearch(f) >= 0) "1" else "0") + " ")
    }
    w.flush()
}