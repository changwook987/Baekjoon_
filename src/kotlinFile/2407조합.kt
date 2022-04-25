package kotlinFile

import java.math.BigInteger

fun main() {
    val map = emptyMap<Pair<BigInteger, BigInteger>, BigInteger>().toMutableMap()

    fun solve(n: BigInteger, m: BigInteger): BigInteger {
        if (m == BigInteger.ZERO || n == m) return BigInteger.ONE
        return map.getOrPut(n to m) { solve(n - BigInteger.ONE, m - BigInteger.ONE) + solve(n - BigInteger.ONE, m) }
    }
    val (n, m) = readln().split(" ").map { it.toBigInteger() }
    println(solve(n, m))
}