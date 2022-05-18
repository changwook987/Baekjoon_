package problem11725

import java.util.*

fun main() {
    val (n, tree) = System.`in`.bufferedReader().use { w ->
        val n = w.readLine().toInt()
        val tree = List(n) { ArrayList<Int>() }

        repeat(n - 1) {
            val (p, c) = w.readLine().split(" ").map { it.toInt() - 1 }
            tree[p] += c
            tree[c] += p
        }

        n to tree
    }

    val parent = IntArray(n) { -1 }

    val queue: Queue<Int> = LinkedList()
    queue += 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in tree[cur]) {
            if (parent[i] != -1) continue
            parent[i] = cur
            queue += i
        }
    }

    System.out.bufferedWriter().use {
        for (i in 1 until n) {
            it.appendLine("${parent[i] + 1}")
        }
        it.flush()
    }
}