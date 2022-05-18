package problem1193

fun main() {
    val n = readln().toInt()
    var i = 1
    var N = n
    while (N > i) {
        N -= i
        i++
    }
    if (i % 2 == 0) println("$N/${i - N + 1}")
    else println("${i - N + 1}/$N")
}