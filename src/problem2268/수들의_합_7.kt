package problem2268

import java.io.StreamTokenizer

val t = StreamTokenizer(System.`in`.reader())

fun nextInt(): Int {
    t.nextToken()
    return t.nval.toInt()
}

fun nextLong(): Long {
    t.nextToken()
    return t.nval.toLong()
}

class SegTree(ints: LongArray) {

    private val tree: LongArray

    init {
        tree = LongArray(ints.size.takeHighestOneBit() shl 2)
        init(ints, 0, ints.size - 1, 1)
    }

    private fun init(ints: LongArray, s: Int, e: Int, cur: Int): Long {
        if (s == e) return ints[s].also { tree[cur] = it }
        val m = (s + e) / 2
        return (init(ints, s, m, cur * 2) + init(ints, m + 1, e, cur * 2 + 1)).also {
            tree[cur] = it
        }
    }

    fun update(s: Int, e: Int, idx: Int, cur: Int, dif: Long) {
        if (idx !in s..e) return

        tree[cur] += dif

        if (s == e) return
        val m = (s + e) / 2

        update(s, m, idx, cur * 2, dif)
        update(m + 1, e, idx, cur * 2 + 1, dif)
    }

    fun add(s: Int, e: Int, cur: Int, l: Int, r: Int): Long {
        if (l > e || r < s) return 0
        if (l <= s && e <= r) return tree[cur]

        val m = (s + e) / 2
        return add(s, m, cur * 2, l, r) + add(m + 1, e, cur * 2 + 1, l, r)
    }

    override fun toString(): String {
        return tree.joinToString()
    }
}

fun main() {
    val size = nextInt()
    val tasks = nextInt()

    val nums = LongArray(size)
    val tree = SegTree(nums)

    System.out.bufferedWriter().use { w ->

        repeat(tasks) {
            val cmd = nextInt()

            if (cmd == 1) {
                val idx = nextInt()
                val value = nextLong()

                val dif = value - nums[idx - 1]

                tree.update(0, size - 1, idx - 1, 1, dif)

                nums[idx - 1] = value
            } else {
                val a = nextInt() - 1
                val b = nextInt() - 1

                if (a < b) w.appendLine(tree.add(0, size - 1, 1, a, b).toString())
                else w.appendLine(tree.add(0, size - 1, 1, b, a).toString())
            }
        }
        w.flush()
    }
}
