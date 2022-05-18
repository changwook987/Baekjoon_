package problem1389

import java.util.*

fun main() {
    fun read() = readln().split(" ").map { it.toInt() }
    val (n, m) = read()

    val arr = IntArray(n)
    val graph = List(n) { ArrayList<Int>() }

    repeat(m) {
        val (a, b) = read()

        graph[a - 1] += b - 1
        graph[b - 1] += a - 1
    }

    var min = Int.MAX_VALUE
    var minIdx = 0

    repeat(n) { j ->
        repeat(n) { i ->
            arr[i] = Int.MAX_VALUE
        }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue += j to 0

        while (queue.isNotEmpty()) {
            val (num, depth) = queue.poll()

            if (arr[num] > depth) {
                arr[num] = depth

                for (i in graph[num]) {
                    queue += i to depth + 1
                }
            }
        }

        arr.sum().let { sum ->
            if (min > sum) {
                min = sum
                minIdx = j + 1
            }
        }
    }

    println(minIdx)
}