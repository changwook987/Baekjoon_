package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val si = BufferedReader(InputStreamReader(System.`in`))
    val so = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(si.readLine())

    val n = token.nextToken().toInt()
    val len = token.nextToken().toInt()

    token = StringTokenizer(si.readLine())
    si.close()

    val trees = Array(n) { token.nextToken().toInt() }.sorted()

    var left = 0
    var right = trees.last()

    while (left < right) {
        val mid = left.plus(right).div(2)

        var add = 0L

        for (i in trees) {
            if (i > mid) {
                add += i.minus(mid)
            }
        }

        if (add < len) {
            right = mid
        } else {
            left = mid.plus(1)
        }
    }

    so.write(left.minus(1).toString())
    so.flush()
    so.close()
}