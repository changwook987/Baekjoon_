package problem9295

fun main() {
    var cases = emptyArray<Int>()
    repeat(readLine()!!.toInt()) {
        readLine()!!.split(' ').apply {
            cases = cases.plus(get(0).toInt().plus(get(1).toInt()))
        }
    }
    cases.forEachIndexed { index, i ->
        println("Case ${index.plus(1)}: $i")
    }
}