package kotlinFile

import java.util.*
import kotlin.math.ceil

fun main() = with(Scanner(System.`in`)) {
    val a = nextInt()
    val i = nextInt()
    var n = a * i
    while (ceil(n / a.toDouble()) >= i) n--
    println(n + 1)
}