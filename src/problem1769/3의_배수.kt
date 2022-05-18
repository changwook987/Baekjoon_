package problem1769

fun main() {
    var i = readln()
    var cnt = 0

    while (i.length > 1) {
        i = i.map { it.digitToInt() }.sum().toString()
        cnt++
    }

    println(cnt)

    if (i.toInt() % 3 == 0) println("YES")
    else println("NO")
}

