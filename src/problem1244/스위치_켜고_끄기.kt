package problem1244

import java.util.*

fun main() {
    val switch = readln().toInt().run {
        val n = this
        StringTokenizer(readln()).run {
            MutableList(n) {
                nextToken().toInt() == 1
            }
        }
    }
    repeat(readln().toInt()) {
        readln().split(" ").run {
            get(0).toInt() to get(1).toInt()
        }.apply {
            if (first == 1) {
                for (i in second.minus(1) until switch.size step second) {
                    switch[i] = !switch[i]
                }
            } else {
                var i = 0
                while (second - 1 - i >= 0 && second - 1 + i < switch.size &&
                    switch[second - 1 - i] == switch[second - 1 + i]
                ) {
                    val b = !switch[second - 1 - i]
                    switch[second - 1 - i] = b
                    switch[second - 1 + i] = b
                    i++
                }
            }
        }
    }
    for (i in switch.indices) {
        print(if (switch[i]) "1 " else "0 ")
        if (i.plus(1).mod(20) == 0) {
            println()
        }
    }
}
