package problem5554

fun main() = List(4) { readln().toInt() }.sum().let {
    println(it / 60)
    println(it % 60)
}