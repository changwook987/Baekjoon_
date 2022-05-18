package problem1991

fun main() {
    data class Node(var left: Int, var right: Int)

    val n = readln().toInt()
    val tree = List(n) { Node(0, 0) }

    repeat(n) {
        val (p, l, r) = readln().split(" ").map { it[0] - 'A' }

        tree[p].left = l
        tree[p].right = r
    }

    fun pre(): String {
        val sb = StringBuilder()

        fun solve(cur: Int) {
            if (cur == -19) return

            sb.append('A' + cur)
            solve(tree[cur].left)
            solve(tree[cur].right)
        }

        solve(0)
        return sb.toString()
    }

    fun `in`(): String {
        val sb = StringBuilder()

        fun solve(cur: Int) {
            if (cur == -19) return

            solve(tree[cur].left)
            sb.append('A' + cur)
            solve(tree[cur].right)
        }

        solve(0)
        return sb.toString()
    }

    fun post(): String {
        val sb = StringBuilder()

        fun solve(cur: Int) {
            if (cur == -19) return

            solve(tree[cur].left)
            solve(tree[cur].right)
            sb.append('A' + cur)
        }

        solve(0)
        return sb.toString()
    }

    println(pre())
    println(`in`())
    println(post())
}
