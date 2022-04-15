package kotlinFile

fun main() {
    val n = readln().toInt()
    repeat(n) {
        repeat(n - it - 1) { print(" ") }
        print("*")
        if (it != 0) {
            repeat((it - 1) * 2 + 1) { print(" ") }
            print("*")
        }
        println()
    }
}