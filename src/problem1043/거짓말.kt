package problem1043

fun read() = readln().split(" ").map { it.toInt() }
fun read2() = read().drop(1)

fun main() {
    val (h, p) = read()
    val disjoint = IntArray(h + 1) { it }
    val parties = Array(p) { IntArray(0) }

    for (known in read2()) {
        disjoint[known] = 0
    }

    fun getRoot(n: Int): Int {
        var cur = n
        while (disjoint[cur] != cur) cur = disjoint[cur]
        return cur
    }

    repeat(p) {
        parties[it] = read2().toIntArray()
        val value = parties[it].minOf { i -> getRoot(i) }

        for (i in parties[it]) {
            disjoint[getRoot(i)] = value
        }
    }

    parties.count {
        !it.any { int ->
            getRoot(int) == 0
        }
    }.let {
        println(it)
    }
}