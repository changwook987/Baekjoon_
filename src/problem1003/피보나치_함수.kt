package problem1003

import java.util.*


fun main() = with(Scanner(System.`in`)) {
    var result = emptyArray<List<Int>>()

    val zero = emptyMap<Int, Int>().toMutableMap()
    val one = emptyMap<Int, Int>().toMutableMap()

    zero[0] = 1
    one[0] = 0
    zero[1] = 0
    one[1] = 1

    fun fib(n: Int): List<Int> {
        if (!zero.contains(n) || !one.contains(n)) {
            val a = fib(n.minus(1))
            val b = fib(n.minus(2))
            zero[n] = a[0] + b[0]
            one[n] = a[1] + b[1]
        }
        return listOf(zero[n]!!, one[n]!!)
    }

    repeat(nextInt()) {
        result = result.plus(fib(nextInt()))
    }
    for (i in result) {
        println("${i[0]} ${i[1]}")
    }
}