package kotlinFile

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))

    val text = r.readLines().joinToString(" ") { it.lowercase() }
    var longSentence = ""

    val sb = StringBuilder()

    for (c in text) {
        if (c in "abcdefghijklmnopqrstuvwxyz-") {
            sb.append(c)
        } else {
            if (longSentence.length < sb.length) {
                longSentence = sb.toString()
            }

            sb.clear()
        }
    }

    println(longSentence)
}