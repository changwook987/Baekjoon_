package problem16430

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()

    fun gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)
    val a = m - n
    val gcd = gcd(a, m)
    println("${a / gcd} ${m / gcd}")
}