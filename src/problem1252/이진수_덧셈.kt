package problem1252

import java.util.*

fun main() {
    val (a, b) = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toBigInteger(2) } }
    println((a + b).toString(2))
}