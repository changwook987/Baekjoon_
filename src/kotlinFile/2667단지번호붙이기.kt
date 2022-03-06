package kotlinFile

import java.util.*

fun main() {
    val n = readln().toInt()
    val graph = List(n) { IntArray(n) { 0 } }

    repeat(n) {
        val str = readln()
        for ((idx, c) in str.withIndex()) {
            if (c == '1') {
                graph[it][idx] = 1
            }
        }
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val range = 0 until n

    val result = ArrayList<Int>()

    for (i in range) {
        for (j in range) {
            queue += j to i
            var size = 0

            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                if (x in range && y in range) {
                    if (graph[y][x] == 1) {
                        graph[y][x] = 0
                        size++

                        queue += x + 1 to y
                        queue += x - 1 to y
                        queue += x to y + 1
                        queue += x to y - 1
                    }
                }
            }

            if (size != 0) result += size
        }
    }

    println(result.size)
    println(result.sorted().joinToString("\n"))
}