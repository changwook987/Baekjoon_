package kotlinFile

import java.util.*

fun main() {
    fun read() = StringTokenizer(readln()).run { List(countTokens()) { nextToken().toInt() } }
    val (n, m) = read()

    class Graphs(v: Int) {
        private val list = IntArray(v) { it }
        private val indices = list.indices

        fun getHead(idx: Int): Int {
            require(idx in indices)

            var cur = idx

            while (cur != list[cur]) {
                cur = list[cur]
            }

            return cur
        }

        fun link(a: Int, b: Int) {
            require(a in indices && b in indices)

            val aHead = getHead(a)
            val bHead = getHead(b)

            if (aHead > bHead)
                list[aHead] = bHead
            else list[bHead] = aHead
        }

        val graphCount: Int
            get() {
                val set = mutableSetOf<Int>()

                for (i in indices) {
                    set += getHead(i)
                }

                return set.size
            }

    }

    val graphs = Graphs(n)

    repeat(m) {
        val (u, v) = read()
        graphs.link(u - 1, v - 1)
    }

    println(graphs.graphCount)
}