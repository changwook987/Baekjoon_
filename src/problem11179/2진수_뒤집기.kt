package problem11179

fun main() {
    fun Int.toReverseBinary(): String {
        var i = this
        var string = ""
        while (i != 0) {
            string += "${i.mod(2)}"
            i /= 2
        }
        return string
    }
    println(readLine()!!.toInt().toReverseBinary().toInt(2))
}

