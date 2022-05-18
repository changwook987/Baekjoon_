package problem15657

fun main() {
    val n = readLine()!!.split(" ")[1].toInt()
    val list = readLine()!!.split(" ").run { List(size) { get(it).toInt() }.toSortedSet() }

    fun write(arr: List<Int> = emptyList()) {
        if (arr.size == n) {
            println(arr.joinToString(" "))
        } else {
            for (i in list.filter {
                val l = arr.lastOrNull() ?: return@filter true
                it >= l
            }) {
                write(arr + i)
            }
        }
    }

    write()
}