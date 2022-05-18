package problem2839

fun main() {
    val sugar = readLine()!!.toInt()

    for (i in sugar.div(5) downTo 0) {
        val j = sugar.minus(i.times(5)).div(3)
        if (i.times(5).plus(j.times(3)) == sugar) {
            println(i + j)
            return
        }
    }
    println(-1)
}
