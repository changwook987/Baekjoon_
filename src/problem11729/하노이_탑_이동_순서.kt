package problem11729

import kotlin.math.pow

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { w ->
        w.write(2.0.pow(n.toDouble()).toInt().minus(1).toString() + "\n")

        fun move(size: Int, from: Int = 1, to: Int = 3) {
            val tmp = 6.minus(from.plus(to))

            if (size == 1) {
                w.write("$from $to\n")
                return
            }
            move(size.minus(1), from, tmp)
            move(1, from, to)
            move(size.minus(1), tmp, to)
        }
        move(n)
        w.flush()
    }
}