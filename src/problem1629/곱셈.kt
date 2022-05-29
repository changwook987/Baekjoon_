package problem1629

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toBigInteger() }
    println(a.modPow(b, c))
}