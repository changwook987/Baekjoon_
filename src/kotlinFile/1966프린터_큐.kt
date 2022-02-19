package kotlinFile

import java.util.*

fun main() {
    fun read(): List<Int> = StringTokenizer(readLine()).run { List(countTokens()) { nextToken().toInt() } }

    val n = readLine()!!.toInt()

    repeat(n) {
        val input = read()
        val queue: Queue<Int> = LinkedList(read())

        var order = 1
        var o = input[1]

        while (queue.isNotEmpty()) {
            val poll = queue.poll()

            if (queue.all { poll >= it }) {
                if (o == 0) {
                    break
                }

                order++
            } else {
                queue += poll
            }

            if (o == 0) {
                o = queue.size - 1
            } else {
                o--
            }
        }

        println(order)
    }
}