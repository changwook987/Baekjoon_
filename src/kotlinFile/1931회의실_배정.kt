package kotlinFile

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) {
        StringTokenizer(readLine()).run {
            listOf(nextToken().toInt(), nextToken().toInt())
        }
    }.sortedWith(compareBy({ it[0] }, { it[1] }))

    println(list)
    fun search(list: List<List<Int>>, curTime: Int = 0, select: Int = 0): Int {
        val llist = list.filter { it[0] >= curTime }

        if (llist.isNotEmpty()) {
            var max = 0
            for (i in llist) {

                max = search(llist, i[1], select.plus(1)).run {
                    if (this > max) {
                        this
                    } else {
                        max
                    }
                }
            }
            return max
        } else {
            return select
        }
    }
    println(search(list))
}

