package problem11444

const val MOD: Int = 1_000_000_007
var origin: Array<LongArray> = emptyArray()

fun main() {
    val b = readln().toLong()
    origin = arrayOf(longArrayOf(1L, 1L), longArrayOf(1L, 0L))
    println((origin pow b)[0][1])
}

operator fun Array<LongArray>.times(other: Array<LongArray>): Array<LongArray> {
    return Array(size) { i ->
        LongArray(size) { j ->
            var result = 0L
            for (k in indices) {
                result += this[i][k] * other[k][j]
                result %= MOD
            }
            result
        }
    }
}

infix fun Array<LongArray>.pow(exp: Long): Array<LongArray> {
    return if (exp == 1L) this
    else {
        var ret = pow(exp / 2)
        ret *= ret

        if (exp % 2 == 1L) ret *= origin

        ret
    }
}