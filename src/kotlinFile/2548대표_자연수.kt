package kotlinFile

import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val n = readln().toInt()
    println(
        StringTokenizer(readln()).run {
            List(n) { nextToken().toInt() }.sorted().run {
                var small = Int.MAX_VALUE
                var smallI = 0
                forEach { i ->
                    var dif = 0
                    forEach { j ->
                        dif += (j - i).absoluteValue
                    }
                    if (small > dif) {
                        small = dif
                        smallI = i
                    }
                }
                smallI
            }
        }
    )
}