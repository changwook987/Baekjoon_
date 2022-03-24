package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))
    fun Int.isPrime(): Boolean {
        if (this < 2) return false
        var i = 2
        while (i * i <= this) {
            if (this % i == 0) return false
            i++
        }
        return true
    }

    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break

        for (i in (2..n.div(2))) {
            if (i.isPrime() && n.minus(i).isPrime()) {
                w.write("$n = $i + ${n.minus(i)}\n")
                break
            }
        }
    }
    w.flush()
}