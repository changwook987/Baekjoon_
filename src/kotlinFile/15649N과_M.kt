package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val r = BufferedReader(InputStreamReader(System.`in`))
val w = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
    r.readLine().split(' ').apply { search(get(0).toInt(), get(1).toInt()) }
    w.flush()
}

fun search(n: Int, m: Int, visit: List<Int> = emptyList()) {
    if (m == 0) {
        for (item in visit) {
            w.write("$item ")
        }
        w.write("\n")
    } else {
        for (i in 1..n) {
            if (!visit.contains(i)) {
                search(n, m.minus(1), visit.plus(i))
            }
        }
    }
}