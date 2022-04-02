package kotlinFile

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (_, x, k) = List(3) { nextInt() }
    println("${k / x} ${k % x}")
}