package kotlinFile

fun main() {
    val n = readLine()!!.split(" ")[1].toInt()
    val list = readLine()!!.split(" ").run { List(size) { get(it).toInt() }.toSortedSet() }

    fun write(arr: List<Int> = emptyList()) {
        if (arr.size == n) {
            println(arr.joinToString(" "))
        } else {
            for (i in list - arr.toSet()) {
                write(arr + i)
            }
        }
    }

    write()
}