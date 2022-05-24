package problem1504

import java.util.*

fun read() = readln().split(" ").map { it.toInt() }

fun main() {
    val (n, e) = read()
    val graph = Array(n + 1) { LinkedList<Pair<Int, Int>>() }

    repeat(e) {
        val (a, b, c) = read()

        graph[a] += b to c
        graph[b] += a to c
    }

    val (n1, n2) = read()

    val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    fun dijkstra(start: Int): IntArray {
        val arr = IntArray(n + 1) { Int.MAX_VALUE }

        priorityQueue += start to 0

        while (priorityQueue.isNotEmpty()) {
            val (end, cost) = priorityQueue.poll()
            if (arr[end] < cost) continue

            arr[end] = cost

            for ((i, c) in graph[end]) {
                priorityQueue += i to c + cost
            }
        }

        return arr
    }

    val arr = dijkstra(1)
    val arr1 = dijkstra(n1)
    val arr2 = dijkstra(n2)

    val oneToN1 = arr[n1]
    val oneToN2 = arr[n2]

    val n1ToN2 = arr1[n2]
    val n1ToN = arr1[n]

    val n2ToN1 = arr2[n1]
    val n2ToN = arr2[n]

    if (oneToN1 == Int.MAX_VALUE
        || oneToN2 == Int.MAX_VALUE
        || n1ToN == Int.MAX_VALUE
        || n1ToN2 == Int.MAX_VALUE
        || n2ToN == Int.MAX_VALUE
        || n2ToN1 == Int.MAX_VALUE
    ) {
        println(-1)
    } else {

        println(
            minOf(
                oneToN1 + n1ToN2 + n2ToN,
                oneToN2 + n2ToN1 + n1ToN
            )
        )
    }
}