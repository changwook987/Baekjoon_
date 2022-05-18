package problem1406

import java.util.*

fun main() {
    val linkedList = LinkedList(readLine()!!.toList())

    val cursor = linkedList.listIterator(linkedList.size)

    repeat(readLine()!!.toInt()) {
        readLine()!!.split(" ").apply {
            with(cursor) {
                when (get(0)) {
                    "L" -> {
                        if (hasPrevious())
                            previous()
                    }
                    "D" -> {
                        if (hasNext())
                            next()
                    }
                    "B" -> {
                        if (hasPrevious()) {
                            previous()
                            remove()
                        }
                    }
                    "P" -> {
                        add(get(1)[0])
                    }
                }
            }
        }
    }
    println(linkedList.joinToString(""))
}