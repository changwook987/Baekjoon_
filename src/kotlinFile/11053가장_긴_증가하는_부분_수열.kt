package kotlinFile

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val list = StringTokenizer(readLine()).run { List(n) { nextToken().toInt() } }

    println(len(list))
}

fun len(list: List<Int>): Int {
    val arr = Array(list.size) { 1 }

    for (i in list.indices) {
        for (j in 0 until i) {
            if (list[j] < list[i] && arr[i] < arr[j] + 1) {
                arr[i] = arr[j] + 1
            }
        }
    }

    return arr.maxOf { it }
}