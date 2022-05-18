package problem1158

import java.util.*

fun main() {
    val a: Int
    val b: Int

    StringTokenizer(readLine()).run {
        a = nextToken().toInt()
        b = nextToken().toInt()
    }

    val arr: Queue<Int> = LinkedList(List(a) { it + 1 })
    val result = ArrayList<Int>()

    var cnt = 0
    while (arr.isNotEmpty()) {
        cnt++

        val poll = arr.poll()

        if (cnt >= b) {
            cnt = 0
            result += poll
        } else {
            arr += poll
        }
    }

    println("<" + result.joinToString(", ") + ">")
}