package kotlinFile

import java.util.*

fun main() {
    var cnt = 0
    val n = readLine()!!.toInt()
    val input = StringTokenizer(readLine())

    fun Int.isPrime(): Boolean {
        if (this < 2) return false
        var i = 2
        while (i * i <= this) {
            if (this % i == 0) return false
            i++
        }
        return true
    }

    repeat(n) {
        if (input.nextToken().toInt().isPrime()) {
            cnt++
        }
    }
    println(cnt)
}