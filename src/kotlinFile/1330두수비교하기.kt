package kotlinFile

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()

    print(
        if (a > b) {
            '>'
        } else if (a < b) {
            '<'
        } else {
            "=="
        }
    )
}