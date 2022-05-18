package problem2252

import java.util.*

fun main() {
    fun r() = readln().split(" ").map(String::toInt)
    val (n, m) = r()
    val graph = List(n) { ArrayList<Int>() }
    val arr = IntArray(n)

    repeat(m) {
        val (c, p) = r()
        graph[p - 1] += c - 1
        arr[c - 1]++
    }

    val queue: Queue<Int> = LinkedList()
    val stack = Stack<Int>()

    for ((j, v) in arr.withIndex()) {
        if (v == 0) {
            queue += j
        }
    }

    while (queue.isNotEmpty()) {
        val x = queue.poll()
        stack += x

        for (i in graph[x]) {
            if (--arr[i] == 0) {
                queue += i
            }
        }
    }

    while (stack.isNotEmpty()) {
        print("${stack.pop() + 1} ")
    }
}