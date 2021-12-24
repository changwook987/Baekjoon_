package kotlinFile

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    val list = List(n) { it + 1 }.filter { n % it == 0 }

    println(
        try {
            list[k - 1]
        } catch (e: IndexOutOfBoundsException) {
            0
        }
    )
}