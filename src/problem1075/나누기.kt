package problem1075

fun main() {
    val n = readln().toInt()
    val a = readln().toInt()

    val m = n / 100 * 100
    println("%02d".format((a - (m % a)) % a))
}