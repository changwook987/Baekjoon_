package kotlinFile

fun main() {
    val n = readLine()!!.toInt()

    var list = emptyList<Int>()

    repeat(n) {
        readLine()!!.apply {
            list = if (length == 7)
                if ("1122122" == replace(get(0), '1').replace(get(3), '2')) {
                    list.plus(1)
                } else
                    list.plus(0)
            else
                list.plus(0)
        }
    }
    for (i in list) {
        println(i)
    }
}