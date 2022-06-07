package problem1145

fun main() {
    val arr = readln().split(" ").map { it.toInt() }
    var i = 1
    while (arr.count { i % it == 0 } < 3) i++
    println(i)
}