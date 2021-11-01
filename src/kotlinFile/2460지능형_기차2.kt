package kotlinFile

import kotlin.math.max

fun main() {
    var maxValue = Int.MIN_VALUE
    var train = 0
    repeat(10) {
        readLine()!!.split(' ').apply {
            train = train - get(0).toInt() + get(1).toInt()
            maxValue = max(maxValue, train)
        }
    }
    println(maxValue)
}