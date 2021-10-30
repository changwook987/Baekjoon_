package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val r = BufferedReader(InputStreamReader(System.`in`))
private val w = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val deque = ArrayDeque<Int>()
    repeat(r.readLine().toInt()) {
        val input = r.readLine().split(' ')
        when (input[0]) {
            "push_front" -> {
                deque.addFirst(input[1].toInt())
            }
            "push_back" -> {
                deque.addLast(input[1].toInt())
            }
            "pop_front" -> {
                w.write(
                    try {
                        deque.removeFirst()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )
            }
            "pop_back" -> {
                w.write(
                    try {
                        deque.removeLast()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )
            }
            "front" -> {
                w.write(
                    try {
                        deque.first()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )
            }
            "back" -> {
                w.write(
                    try {
                        deque.last()
                    } catch (e: NoSuchElementException) {
                        -1
                    }.toString() + "\n"
                )
            }
            "size" -> {
                w.write(deque.size.toString() + "\n")
            }
            "empty" -> {
                w.write(if (deque.isEmpty()) "1\n" else "0\n")
            }
        }
    }
    w.flush()
}