package problem1764

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val a = StringTokenizer(r.readLine()).run { nextToken().toInt() to nextToken().toInt() }

    val hashSet = HashSet<String>()

    repeat(a.first) {
        hashSet += r.readLine()
    }

    val arr = ArrayList<String>()

    repeat(a.second) {
        val read = r.readLine()
        if (read in hashSet) {
            arr += read
        }
    }

    arr.sort()

    BufferedWriter(OutputStreamWriter(System.out)).apply {
        appendLine(arr.size.toString())
        for (str in arr) {
            appendLine(str)
        }
        flush()
    }
}