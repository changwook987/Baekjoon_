package problem11047

fun main() {
    val n: Int
    var k: Int
    readLine()!!.split(' ').apply { n = get(0).toInt();k = get(1).toInt() }

    val list = List(n) { readLine()!!.toInt() }

    var i = 0
    while (k != 0) {
        i++
        k -= list.last { k >= it }
    }

    println(i)
}