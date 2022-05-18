package problem15663

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map: SortedMap<Int, Int> = TreeMap<Int, Int>().apply {
        val tokenizer = StringTokenizer(readln())

        repeat(n) {
            val key = tokenizer.nextToken().toInt()
            put(key, getOrDefault(key, 0) + 1)
        }
    }

    val set = HashSet<String>()

    fun solve(list: List<Int> = emptyList()) {
        if (list.size == m) {
            val str = list.joinToString(" ")
            if (str in set) return
            println(str)
            set += str
        } else {
            for ((k, v) in map) {
                if (v > 0) {
                    map[k] = v - 1
                    solve(list + k)
                    map[k] = v
                }
            }
        }
    }

    solve()
}