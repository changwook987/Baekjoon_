package kotlinFile

import java.util.*

fun main() {
    val stack = Stack<Char>()
    val str = readln()
    val bomb = readln()
    val bombLength = bomb.length

    fun check(stackSize: Int): Boolean {
        if (stackSize < bombLength) return false

        val start = stackSize - bombLength
        for (i in bomb.indices) {
            if (stack[start + i] != bomb[i]) return false
        }
        return true
    }

    for (c in str) {
        stack += c
        val stackSize = stack.size

        if (check(stackSize)) {
            repeat(bombLength) {
                stack.pop()
            }
        }
    }

    if (stack.isEmpty()) println("FRULA")
    else println(stack.joinToString(""))
}