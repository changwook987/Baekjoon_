package kotlinFile

fun main() {
    val arr = readln().split("-").map { s -> s.split("+").sumOf { it.toInt() } }
    var tot = arr.first()

    for (i in 1 until arr.size) {
        tot -= arr[i]
    }

    println(tot)
}