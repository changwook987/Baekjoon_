package problem10768

fun main() {
    val mon = readln().toInt().compareTo(2)
    val day = readln().toInt().compareTo(18)

    when (mon) {
        1 -> "After"
        -1 -> "Before"
        else -> {
            when (day) {
                1 -> "After"
                -1 -> "Before"
                else -> "Special"
            }
        }
    }.let {
        println(it)
    }
}