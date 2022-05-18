package problem5525

fun main() {
    val len = readln().toInt()
    readln()

    var i = 0

    val list = ArrayList<Int>()

    for (c in readln()) {
        if (c == if (i % 2 == 0) 'I' else 'O') {
            i++
        } else {
            list += (i - 1) / 2

            i = if (c == 'I') {
                1
            } else {
                0
            }
        }
    }

    list += (i - 1) / 2

    list.filter {
        it >= len
    }.sumOf {
        it - len + 1
    }.let {
        println(it)
    }
}