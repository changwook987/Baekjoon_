package kotlinFile

import java.util.*

fun main() {
    val vertex = readln().toInt()
    val edge = readln().toInt()
    val arr = IntArray(vertex + 1) { it }

    fun r() = readln().split(" ").map { it.toInt() }
    fun findRoot(i: Int): Int {
        var cur = i
        while (arr[cur] != cur) cur = arr[cur]
        return cur
    }

    val pq = PriorityQueue<Pair<Pair<Int, Int>, Int>>(compareBy { it.second })
    repeat(edge) {
        val (a, b, cost) = r()
        pq += (a to b) to cost
    }

    var tot = 0

    while (pq.isNotEmpty()) {
        val (e, c) = pq.poll()
        val (a, b) = e

        val rootA = findRoot(a)
        val rootB = findRoot(b)

        if (rootA != rootB) {
            tot += c
            arr[rootA] = rootB
        }
    }

    println(tot)
}