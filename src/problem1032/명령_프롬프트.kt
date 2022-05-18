package problem1032

fun main() {
    val n = readLine()!!.toInt()

    val list = List(n) { readLine()!! }
    var str = ""
    for (i in 0 until list[0].length) {
        var miss = 0
        var c = ' '
        for (j in 0 until n) {
            val char = list[j][i]
            if (c != char) {
                miss++
                c = char
            }
        }

        str += if (miss == 1) c else '?'
    }
    println(str)
}