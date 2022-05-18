package problem9251

fun main() {
    val a = readln()
    val b = readln()

    val arr = Array(b.length + 1) { IntArray(a.length + 1) }

    for (y in 1..b.length) {
        for (x in 1..a.length) {
            arr[y][x] = if (a[x - 1] == b[y - 1]) arr[y - 1][x - 1] + 1
            else maxOf(
                arr[y - 1][x],
                arr[y][x - 1]
            )
        }
    }

    println(arr[b.length][a.length])
}