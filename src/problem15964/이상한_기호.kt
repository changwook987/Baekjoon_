package problem15964

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (n, m) = nextLong() to nextLong()
    println((n - m) * (n + m))
}