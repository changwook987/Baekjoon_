package kotlinFile

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val tree = scanner.nextInt()
    val tall = scanner.nextInt()
    var trees = emptyArray<Int>()

    for (i in 0 until tree) {
        trees = trees.plus(scanner.nextInt())
    }
    trees.sort()

    for (i in trees.last() downTo 0) {
        var add = 0
        for (j in trees) {
            add += j.minus(i).coerceAtLeast(0)
        }
        if (add >= tall) {
            println(i)
            break
        }
    }
}
