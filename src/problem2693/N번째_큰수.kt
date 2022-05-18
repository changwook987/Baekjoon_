package problem2693

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    println(List(n) {
        StringTokenizer(readLine()).run {
            List(10) {
                nextToken().toInt()
            }.sorted()[7]
        }
    }.joinToString("\n"))
}