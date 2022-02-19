package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val w = BufferedWriter(OutputStreamWriter(System.out))

    val n = r.readLine().toInt()
    val queue: Queue<Int> = LinkedList()

    repeat(n) {
        val commands = r.readLine().split(' ')

        when (commands[0]) {
            "push" -> queue += commands[1].toInt()
            "pop" -> w.appendLine((queue.poll() ?: -1).toString())
            "size" -> w.appendLine((queue.size).toString())
            "empty" -> w.appendLine((if (queue.isEmpty()) 1 else 0).toString())
            "front" -> w.appendLine((queue.firstOrNull() ?: -1).toString())
            "back" -> w.appendLine((queue.lastOrNull() ?: -1).toString())
        }
    }
    w.flush()
}