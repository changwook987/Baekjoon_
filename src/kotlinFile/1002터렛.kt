package kotlinFile

import java.util.*

fun main() {
    val n = readln().toInt()

    fun read() = StringTokenizer(readln()).run { List(countTokens()) { nextToken().toInt() } }
    operator fun <E> List<E>.component6(): E = getOrNull(5) ?: throw NoSuchElementException()

    repeat(n) {
        val (x1, y1, r1, x2, y2, r2) = read()

        val d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
        val plus = (r1 + r2) * (r1 + r2)
        val minus = (r1 - r2) * (r1 - r2)

        if (d == 0 && r1 == r2) {
            println(-1)
        } else if (d in (minus + 1) until plus) {
            println(2)
        } else if (d == plus || d == minus) {
            println(1)
        } else if (d > plus || d < minus) {
            println(0)
        } else {
            println(-1)
        }
    }
}