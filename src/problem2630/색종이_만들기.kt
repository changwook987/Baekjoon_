package problem2630

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

    fun count(x: Int = 0, y: Int = 0, size: Int = n, c: Int): Int {
        return if (size == 1) {
            if (map[x][y] == c) -1
            else 0
        } else {
            val sizeDiv = size / 2

            val p1 = count(x, y, sizeDiv, c)
            val p2 = count(x + sizeDiv, y, sizeDiv, c)
            val p3 = count(x, y + sizeDiv, sizeDiv, c)
            val p4 = count(x + sizeDiv, y + sizeDiv, sizeDiv, c)


            if (p1 == -1 && p2 == -1 && p3 == -1 && p4 == -1) {
                -1
            } else {
                var count = 0

                if (p1 == -1) count++ else count += p1
                if (p2 == -1) count++ else count += p2
                if (p3 == -1) count++ else count += p3
                if (p4 == -1) count++ else count += p4

                count
            }
        }
    }

    count(c = 0).let {
        println(if (it == -1) 1 else it)
    }
    count(c = 1).let {
        println(if (it == -1) 1 else it)
    }
}