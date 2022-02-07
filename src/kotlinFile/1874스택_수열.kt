package kotlinFile

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val list = ArrayList(List(n) { readLine()!!.toInt() })
    val stack = Stack<Int>()
    val sb = StringBuilder()

    for (i in 1..n) {
        stack += i
        sb.appendLine("+")

        while (stack.isNotEmpty() && stack.peek() == list.first()) {
            list.removeFirst()
            stack.pop()
            sb.appendLine("-")
        }
    }

    if (stack.isEmpty()) {
        println(sb)
    } else {
        println("NO")
    }
}