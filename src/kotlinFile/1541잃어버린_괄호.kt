package kotlinFile

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()
    val n = r.readLine().toInt()
    repeat(n) {
        val cmd = r.readLine()
        var left = true

        r.readLine()

        val deque: Deque<Int> = LinkedList(
            with(StringTokenizer(r.readLine(), "[,]")) {
                List(countTokens()) {
                    nextToken().toInt()
                }
            }
        )
        try {
            for (c in cmd) {
                if (c == 'R') {
                    left = !left
                } else {
                    if (left) {
                        deque.pollFirst() ?: throw Exception()
                    } else {
                        deque.pollLast() ?: throw Exception()
                    }
                }
            }
            w.appendLine(
                if (left) '[' + deque.joinToString(",") + ']'
                else '[' + deque.reversed().joinToString(",") + ']'
            )
        } catch (e: Exception) {
            w.appendLine("error")
        }
    }
    w.flush()
}