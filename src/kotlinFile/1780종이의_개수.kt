package kotlinFile

import java.util.*

fun main() {
    val n = readln().toInt()

    val map = List(n) {
        with(StringTokenizer(readln())) {
            IntArray(n) {
                nextToken().toInt()
            }
        }
    }

    val cnt = IntArray(3)

    fun count(x: Int, y: Int, size: Int): Int? {
        if (size == 1) {
            return map[y][x]
        }
        val s = size / 3

        var isOne = true

        val list = List(9) {
            count((it % 3) * s + x, (it / 3) * s + y, s).apply {
                if (this == null) {
                    isOne = false
                }
            }
        }

        if (isOne) {
            for (i in 1..8) {
                if (list[0] != list[i]) {
                    isOne = false
                }
            }
        }

        return if (isOne) {
            list[0]
        } else {
            for (i in list) {
                if (i == null) continue
                cnt[i + 1]++
            }
            null
        }
    }

    count(0, 0, n)?.let { cnt[it + 1]++ }
    println(cnt.joinToString("\n"))
}