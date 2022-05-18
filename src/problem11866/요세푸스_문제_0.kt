package problem11866

fun main() {
    val n: Int
    val m: Int
    readLine()!!.split(' ').apply { n = get(0).toInt();m = get(1).toInt() }
    val list = MutableList(n) { it.plus(1) }
    val out = emptyList<Int>().toMutableList()
    var top = 0

    while (list.size != 0) {
        top += m.minus(1)
        top %= list.size
        out.add(list.removeAt(top))
    }

    println(out.toString().replace('[', '<').replace(']', '>'))
}