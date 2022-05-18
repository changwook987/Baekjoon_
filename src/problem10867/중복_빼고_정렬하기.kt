package problem10867

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val token = StringTokenizer(readLine())

    val list = List(n) { token.nextToken().toInt() }.toSortedSet()

    for (i in list) {
        print("$i ")
    }
}