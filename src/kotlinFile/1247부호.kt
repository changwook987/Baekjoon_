package kotlinFile

import java.math.BigInteger

fun main() = System.out.bufferedWriter().use { w ->
    repeat(3) {
        List(readln().toInt()) { readln().toBigInteger() }.sumOf { it }.let {
            if (it > BigInteger.ZERO) w.appendLine("+")
            else if (it < BigInteger.ZERO) w.appendLine("-")
            else w.appendLine("0")
        }
    }
    w.flush()
}