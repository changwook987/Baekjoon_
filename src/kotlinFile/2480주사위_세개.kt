package kotlinFile

fun main() {
    val list = with(readln().split(' ')) { List(size) { get(it).toInt() } }
    val pair = list.groupingBy { it }.eachCount().toList().sortedWith(compareBy({ it.second }, { it.first })).last()

    when (pair.second) {
        3 -> 10000 + 1000 * pair.first
        2 -> 1000 + 100 * pair.first
        else -> 100 * pair.first
    }.let {
        println(it)
    }
}