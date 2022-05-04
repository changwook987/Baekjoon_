package kotlinFile

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val max = arr.maxOf { it }

    var avg = 0.0

    for (i in arr) {
        avg += i / max.toDouble()
    }

    avg *= 100
    avg /= n

    println(avg)
}