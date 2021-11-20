package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun Int.isPrime(): Boolean {
    if (primes.contains(this)) {
        return true
    } else {
        if (this < 2) return false
        var i = 2
        while (i * i <= this) {
            if (this % i == 0) return false
            i++
        }
        primes.add(this)
        return true
    }
}

private val primes = emptyList<Int>().toMutableSet()

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))
    var n = readLine()!!.toInt()
    while (n != 0) {
        w.write("${List(n.times(2)) { it.plus(1) }.count { it > n && it.isPrime() }}\n")
        n = readLine()!!.toInt()
    }
    w.flush()
}
