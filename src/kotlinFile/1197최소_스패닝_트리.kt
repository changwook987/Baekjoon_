package kotlinFile

import java.util.*

fun main() {
    data class Edge(val a: Int, val b: Int, val cost: Int) : Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return cost - other.cost
        }
    }

    fun r() = readln().split(" ").map { it.toInt() }

    val (vertex, edge) = r()
    val roots = IntArray(vertex + 1) { it }
    val edges = ArrayList<Edge>()

    fun findRoot(i: Int): Int {
        var cur = i
        while (roots[cur] != cur) {
            cur = roots[cur]
        }
        return cur
    }

    val pq = PriorityQueue<Edge>()

    repeat(edge) {
        val (a, b, c) = r()
        pq += Edge(a, b, c)
    }

    while (pq.isNotEmpty()) {
        val cur = pq.poll()
        val (a, b) = cur

        if (findRoot(a) != findRoot(b)) {
            roots[findRoot(b)] = findRoot(a)
            edges += cur
        }
    }

    println(edges.sumOf { it.cost })
}