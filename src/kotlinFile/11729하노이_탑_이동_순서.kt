package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

private val r = BufferedReader(InputStreamReader(System.`in`))
private val w = BufferedWriter(OutputStreamWriter(System.out))

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

fun main() {

    val n = r.readLine().toInt()
    w.write(2.0.pow(n.toDouble()).toInt().minus(1).toString() + "\n")
    move(n)
    w.flush()
}