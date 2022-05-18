package problem1476

fun main() {
    class Date(val E: Int, val S: Int, val M: Int) {
        override fun toString(): String {
            return "$E, $S, $M"
        }
    }

    fun convert(num: Int): Date {
        return Date(
            num.minus(1).mod(15).plus(1),
            num.minus(1).mod(28).plus(1),
            num.minus(1).mod(19).plus(1)
        )
    }

    val date = readLine()!!.split(' ').run { Date(get(0).toInt(), get(1).toInt(), get(2).toInt()) }
    var i = 1

    while (date.toString() != convert(i).toString()) i++
    println(i)
}


