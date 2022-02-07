package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val l = readLine()!!.split(" ").last().toInt()
    val list = readLine()!!.split(" ").run { List(size) { get(it).toInt() } }.toSortedSet()

    fun p(list: Collection<Int>, len: Int, w: BufferedWriter, visit: List<Int> = emptyList()) {
        if (len == 0) {
            w.appendLine(visit.joinToString(" "))
        } else {
            for (i in list) {
                p(list, len - 1, w, visit.plus(i))
            }
        }
    }
    BufferedWriter(OutputStreamWriter(System.out)).apply {
        p(list, l, this)
        flush()
    }
}