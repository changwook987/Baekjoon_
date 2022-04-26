package kotlinFile

fun main() = repeat(readln().toInt()) {
    println(
        if (
            readln().let {
                if (it.length != 7) false
                else {
                    val a = it[0]
                    val b = it[2]

                    it.replace(a, '1').replace(b, '2') == "1122122"
                }
            }
        ) 1
        else 0
    )
}