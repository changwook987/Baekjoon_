package problem10699

import java.util.*

fun main() {
    val calendar = GregorianCalendar()
    println("%04d-%02d-%02d".format(calendar.weekYear, calendar[2].plus(1), calendar[5]))
}