package problem5582

fun main() {
    val a = readln()
    val b = readln()

    val arr = Array(b.length + 1) { IntArray(a.length + 1) }
    var max = 0

    for (i in 1..b.length) {
        for (j in 1..a.length) {
            if (a[j - 1] == b[i - 1]) {
                arr[i][j] = arr[i - 1][j - 1] + 1
                max = maxOf(max, arr[i][j])
            }
        }
    }

    println(max)
}