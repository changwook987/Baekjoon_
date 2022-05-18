package problem2605

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val st = StringTokenizer(readLine())

    val list = ArrayList<Int>()

    repeat(n) {
        val iterator = list.listIterator(list.size)

        repeat(st.nextToken().toInt()) {
            if (iterator.hasPrevious()) {
                iterator.previous()
            }
        }

        iterator.add(it + 1)
    }

    println(list.joinToString(" "))
}