package problem11399

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    var cnt = 0
    var pre = 0
    StringTokenizer(readLine()).apply {
        List(n) { nextToken().toInt() }.sorted().apply {
            forEach {
                pre += it
                cnt += pre
            }
            println(cnt)
        }
    }
}