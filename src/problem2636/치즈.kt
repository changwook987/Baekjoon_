package problem2636

import java.io.StreamTokenizer
import java.util.*

val t = StreamTokenizer(System.`in`.reader())
fun nextInt(): Int {
    t.nextToken()
    return t.nval.toInt()
}

fun main() {
    val h = nextInt()
    val w = nextInt()

    val graph = Array(h + 2) { IntArray(w + 2) }

    for (i in 1..h) {
        for (j in 1..w) {
            graph[i][j] = -nextInt()
        }
    }

    val queue: Deque<Pair<Pair<Int, Int>, Int>> = LinkedList()
    queue += 0 to 0 to 1

    var max = 0
    var maxCnt = 0

    while (queue.isNotEmpty()) {
        val (pos, time) = queue.poll()
        val (x, y) = pos



        fun add(x: Int, y: Int) {
            if (x !in 0 until w + 2 || y !in 0 until h + 2) return

            if (graph[y][x] == -1) {
                graph[y][x] = time + 1

                if (max < graph[y][x]) {
                    max = graph[y][x]
                    maxCnt = 0
                }

                if (max == graph[y][x]) {
                    maxCnt++
                }

                queue.addLast(x to y to time + 1)
            } else if (graph[y][x] == 0) {
                graph[y][x] = time
                queue.addFirst(x to y to time)
            }
        }

        add(x + 1, y)
        add(x - 1, y)
        add(x, y + 1)
        add(x, y - 1)
    }

    println("${max - 1}\n$maxCnt")
}