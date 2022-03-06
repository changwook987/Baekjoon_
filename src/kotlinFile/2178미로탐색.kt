package kotlinFile

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").run { get(0).toInt() to get(1).toInt() }

    val graph = List(n) { IntArray(m) { 0 } }

    repeat(n) {
        val str = readln()
        for ((idx, c) in str.withIndex()) {
            if (c == '1') {
                graph[it][idx] = 1
            }
        }
    }

    val queue: Queue<List<Int>> = LinkedList(listOf(listOf(0, 0, 1)))

    while (queue.isNotEmpty()) {
        val (x, y, c) = queue.poll()

        if (x in 0 until m && y in 0 until n) {
            if (graph[y][x] == 1) {
                graph[y][x] = c + 1

                queue += listOf(x + 1, y, c + 1)
                queue += listOf(x - 1, y, c + 1)
                queue += listOf(x, y + 1, c + 1)
                queue += listOf(x, y - 1, c + 1)
            }

            if (x == m - 1 && y == n - 1) {
                println(c)
                return
            }
        }
    }
}