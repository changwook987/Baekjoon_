package kotlinFile

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val iter = readLine()!!.iterator()
        val linkedList = LinkedList<Char>()

        val listIterator = linkedList.listIterator()


        while (iter.hasNext()) {
            when (val char = iter.nextChar()) {
                '<' -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous()
                    }
                }
                '>' -> {
                    if (listIterator.hasNext()) {
                        listIterator.next()
                    }
                }
                '-' -> {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous()
                        listIterator.remove()
                    }
                }
                else -> {
                    listIterator.add(char)
                }
            }
        }

        println(linkedList.joinToString(""))
    }
}