package kotlinFile

import java.util.*

fun main() {
    val n = readln().split(' ')[1].toInt()
    val list = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }.sorted()

    val visited = ArrayList<List<Int>>()

    fun write(arr: List<Int> = emptyList()) {
        if (arr.size == n) {
            if (arr !in visited) {
                println(arr.joinToString(" "))
                visited += arr
            }
        } else {
            for (i in list.filter { it >= (arr.lastOrNull() ?: 0) }) {
                write(arr + i)
            }
        }
    }

    write()
}