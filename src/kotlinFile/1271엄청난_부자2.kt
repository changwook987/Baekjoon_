package kotlinFile

import java.util.*

fun main() {
    val (n, m) = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toBigInteger() } }
    println(n / m)
    println(n % m)
}