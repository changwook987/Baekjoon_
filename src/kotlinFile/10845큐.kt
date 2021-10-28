package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private val r = BufferedReader(InputStreamReader(System.`in`))
private val w = BufferedWriter(OutputStreamWriter(System.out))

fun r() = r.readLine().split(' ')

fun main() {
    val queue: Queue<Int> = LinkedList()

    repeat(r()[0].toInt()) {
        val op = r()
        when (op[0]) {
            "push" -> {
                queue.add(op[1].toInt())
            }
            "pop" -> {
                w.write((queue.poll() ?: -1).toString() + "\n")
            }
            "front" -> {
                w.write(
                    try {
                        queue.first()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )
            }
            "back" -> {
                w.write(
                    try {
                        queue.last()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )

            }
            "size" -> {
                w.write((queue.size).toString() + "\n")
            }
            "empty" -> {
                w.write(if (queue.isEmpty()) "1\n" else "0\n")
            }
        }
    }
    w.flush()
}