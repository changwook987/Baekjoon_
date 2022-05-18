package problem11098

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine()!!.toInt()) {
        w.appendLine(
            List(readLine()!!.toInt()) {
                readLine()!!.split(" ").run { get(0).toInt() to get(1) }
            }.sortedWith(compareBy { it.first }).last().second
        )
    }
    w.flush()
}