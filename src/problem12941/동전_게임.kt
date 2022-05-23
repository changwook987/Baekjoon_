package problem12941

val memo = Array(2) { mutableMapOf<Int, Int>() }

fun grundy(n: Int, k: Boolean): Int {
    if (n == 0) return 0

    return memo[if (k) 1 else 0].getOrPut(n) {
        val arr = BooleanArray(n + 1)
        var i = 0

        if (k) {
            if (n % 2 == 0) arr[0] = true
            arr[grundy(n - 1, true)] = true
        } else {
            if (n % 2 == 0) arr[grundy(n / 2, false)] = true
            arr[grundy(n - 1, false)] = true
        }

        while (arr[i]) i++
        i
    }
}

fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() % 2 == 0 }
    val list = readln().split(" ").map { grundy(it.toInt(), k) }
    val g = list.reduce(Int::xor)
    if(g==0) println("Nicky")
    else println("Kevin")
}