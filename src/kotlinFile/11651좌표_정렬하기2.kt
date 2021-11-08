package kotlinFile

class pos(val x: Int, val y: Int) {
    override fun toString(): String {
        return "$x $y"
    }
}

fun main() {
    val list = List(readLine()!!.toInt()) {
        readLine()!!.split(' ').run {
            pos(get(0).toInt(), get(1).toInt())
        }
    }.sortedWith(
        compareBy({ it.y }, { it.x })
    )
    for (i in list) {
        println(i)
    }
}

