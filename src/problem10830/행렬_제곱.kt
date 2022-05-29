package problem10830

const val MOD: Int = 1000
var origin: Array<IntArray> = emptyArray()

fun main() {
    val (n, b) = readln().split(" ").map { it.toLong() }
    origin = Array(n.toInt()) { readln().split(" ").map { it.toInt() % MOD }.toIntArray() }
    println(origin.pow(b).joinToString("\n") { it.joinToString(" ") })
}

operator fun Array<IntArray>.times(other: Array<IntArray>): Array<IntArray> {
    return Array(size) { i ->
        IntArray(size) { j ->
            var result = 0
            for (k in indices) {
                result += this[i][k] * other[k][j]
                result %= MOD
            }
            result
        }
    }
}

fun Array<IntArray>.pow(exp: Long): Array<IntArray> {
    return if (exp == 1L) this
    else {
        var ret = pow(exp / 2)
        ret *= ret

        if (exp % 2 == 1L) ret *= origin

        ret
    }
}