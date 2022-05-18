package problem1755

fun main() {
    fun Int.toStreeing(): String {
        var str = ""
        for (i in this.toString()) {
            str += when (i) {
                '0' -> "zero "
                '1' -> "one "
                '2' -> "two "
                '3' -> "three "
                '4' -> "four "
                '5' -> "five "
                '6' -> "six "
                '7' -> "seven "
                '8' -> "eight "
                '9' -> "nine "
                else -> ""
            }
        }
        return str
    }

    readLine()!!.split(' ').apply {
        val a = get(0).toInt()
        val b = get(1).toInt()

        val list = List(b - a + 1) { it + a }.sortedBy { it.toStreeing() }
        for (i in list.indices) {
            print("${list[i]} ")
            if (i.plus(1) % 10 == 0)
                println()
        }
    }
}

