package problem2096

fun main() {
    val n = readln().toInt()
    val max = Array(n + 1) { IntArray(5) }
    val min = Array(n + 1) { IntArray(5) { Int.MAX_VALUE } }
    min[0] = IntArray(5)

    for (y in 1..n) {
        val line = readln().split(" ").map { it.toInt() }
        repeat(3) {
            max[y][it + 1] = maxOf(max[y - 1][it], max[y - 1][it + 1], max[y - 1][it + 2]) + line[it]
            min[y][it + 1] = minOf(min[y - 1][it], min[y - 1][it + 1], min[y - 1][it + 2]) + line[it]
        }
    }

    println("${max[n].maxOf { it }} ${min[n].minOf { it }}")
}