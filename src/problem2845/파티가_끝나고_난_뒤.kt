package problem2845

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val p = nextInt() * nextInt()
    repeat(5) {
        print("${nextInt() - p} ")
    }
}