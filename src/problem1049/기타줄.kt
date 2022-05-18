package problem1049

import java.util.*
import kotlin.math.min

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()

    var min = Int.MAX_VALUE

    var pack = Int.MAX_VALUE
    var one = Int.MAX_VALUE
    repeat(m) {
        pack = min(nextInt(), pack)
        one = min(nextInt(), one)
    }

    val packOnly = (n.div(6) + if (n.mod(6) == 0) 0 else 1).times(pack)
    val packAndOne = n.div(6).times(pack) + n.mod(6).times(one)
    val oneOnly = n.times(one)

    min = min(packOnly, min)
    min = min(packAndOne, min)
    min = min(oneOnly, min)

    println(min)
}