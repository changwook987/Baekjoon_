package kotlinFile

import java.util.*


fun main() {
    val queue: Queue<Int> = LinkedList()
    fun r() = readln().split(" ")

    System.out.bufferedWriter().use { w ->
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
}