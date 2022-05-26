package problem2580

fun main() {
    val zeros = ArrayList<Pair<Int, Int>>()
    val map = Array(9) { y ->
        var x = 0
        readln().split(" ").map {
            it.toInt().apply {
                if (this == 0) {
                    zeros += x to y
                }

                x++
            }
        }.toIntArray()
    }

    val iter = zeros.listIterator()

    fun check(c: Int, x: Int, y: Int): Boolean {
        repeat(9) { i ->
            if (map[i][x] == c) return false
            if (map[y][i] == c) return false
            if (map[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3] == c) return false
        }
        return true
    }

    fun solve(): Boolean {
        if (iter.hasNext()) {
            val (x, y) = iter.next()

            for (i in 1..9) {
                if (check(i, x, y)) {
                    map[y][x] = i
                    if (solve()) return true
                    map[y][x] = 0
                }
            }

            iter.previous()
            return false
        } else {
            return true
        }
    }

    solve()

    System.out.bufferedWriter().use {
        for (row in map) {
            for (i in row) {
                it.append("$i ")
            }
            it.append("\n")
        }
        it.flush()
    }
}