package problem4949

import java.util.*

fun main() {
    while (true) {
        val input = readLine()!!

        if (input == ".") return

        val stack = Stack<Char>()

        for (c in input) {
            if (c !in "()[]") continue

            if (stack.isEmpty()) {
                stack += c
                continue
            }

            when ("${stack.peek()}$c") {
                "()", "[]" -> {
                    stack.pop()
                }
                else -> {
                    stack += c
                }
            }
        }

        println(
            if (stack.isEmpty())
                "yes" else "no"
        )
    }
}