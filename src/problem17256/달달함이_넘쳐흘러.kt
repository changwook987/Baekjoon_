package problem17256

import java.util.*

fun main() {
    data class Cake(val x: Int, val y: Int, val z: Int) {
        override fun toString(): String {
            return "$x $y $z"
        }
    }

    fun makeCake(str: String): Cake {
        return with(StringTokenizer(str)) {
            val (x, y, z) = List(3) { nextToken().toInt() }
            Cake(x, y, z)
        }
    }

    val a = makeCake(readln())
    val c = makeCake(readln())

    println(
        Cake(
            c.x - a.z,
            c.y / a.y,
            c.z - a.x
        )
    )
}