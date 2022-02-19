package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val w = BufferedWriter(OutputStreamWriter(System.out))

    val commands = r.readLine().split(' ')
    val n = commands[0].toInt()
    val m = commands[1].toInt()

    val hashMap = HashMap<String, Int>()
    val arr = ArrayList<String>()

    repeat(n) {
        with(r.readLine()) {
            hashMap += this to it + 1
            arr += this
        }
    }

    repeat(m) {
        val input = r.readLine().run { toIntOrNull() ?: this }

        if (input is Int) {
            w.appendLine(arr[input - 1])
        } else if (input is String) {
            w.appendLine(hashMap[input].toString())
        }
    }
    w.flush()
}