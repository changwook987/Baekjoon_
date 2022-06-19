package problem11758

import java.io.StreamTokenizer

val tk = StreamTokenizer(System.`in`.reader())
fun int(): Int {
    tk.nextToken()
    return tk.nval.toInt()
}

fun main() = println(ccw(int(), int(), int(), int(), int(), int()))

fun ccw(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int) =
    ((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)).compareTo(0)