package problem1004

fun read() = readln().split(" ").map { it.toInt() }
fun Int.x() = this * this

fun main() {
    repeat(readln().toInt()) {
        val (x1, y1, x2, y2) = read()

        var a = 0
        var b = 0

        repeat(readln().toInt()) {
            val (x, y, c) = read()

            val t1 = (x1 - x).x() + (y1 - y).x() <= c.x()
            val t2 = (x2 - x).x() + (y2 - y).x() <= c.x()

            if (t1 xor t2) {
                if (t1) a++
                else b++
            }
        }

        println(a + b)
    }
}