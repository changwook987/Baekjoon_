package kotlinFile

import java.util.*

fun main() {
    data class Node(
        val value: Int,
        val child: ArrayList<Node> = ArrayList()
    )

    val n = readln().toInt()
    val root = run {
        var root: Node? = null

        val list = List(n) { Node(it) }
        val st = StringTokenizer(readln())

        repeat(n) { i ->
            val m = st.nextToken().toInt()
            if (m == -1) {
                root = list[i]
            } else {
                list[m].child += list[i]
            }
        }

        root!!
    }

    val ignore = readln().toInt()

    fun dfs(cur: Node): Int {
        if (cur.value == ignore) return 0
        val child = cur.child.filter { it.value != ignore }
        return if (child.isEmpty()) 1
        else {
            var cnt = 0

            for (node in child) {
                cnt += dfs(node)
            }

            cnt
        }
    }

    println(dfs(root))
}