package kotlinFile



fun main() {
    class Pos(val x: Int, val y: Int) {
        override fun toString(): String {
            return "$x $y"
        }
    }
    val list = List(readLine()!!.toInt()) {
        readLine()!!.split(' ').run {
            Pos(get(0).toInt(), get(1).toInt())
        }
    }.sortedWith(
        compareBy({ it.y }, { it.x })
    )
    for (i in list) {
        println(i)
    }
}

