package problem1934


fun main() {
    fun u(a: Int, b: Int): Int {
        return if (a % b != 0) u(b, a % b) else b
    }

    List(readLine()!!.toInt()) {
        readLine()!!.split(' ').run {
            val a = get(0).toInt()
            val b = get(1).toInt()
            u(a, b).run {
                a.div(this) * b
            }
        }
    }.forEach { println(it) }
}