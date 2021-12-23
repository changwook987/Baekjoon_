package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine()!!.toInt()) {
        val hauls = readLine()!!.split(" ").toMutableList()

        var input: String
        do {
            input = readLine()!!
            hauls.removeIf { it == input.split(" ")[2] }
        } while (input != "what does the fox say?")

        w.appendLine(hauls.joinToString(" "))
    }
    w.flush()
}