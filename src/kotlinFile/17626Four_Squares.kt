package kotlinFile

/**
 * 1 = 1^2                      1
 * 2 = 1^2 + 1^2                2
 * 3 = 1^2 + 1^2 + 1^2          3
 * 4 = 2^2                      1
 * 5 = 2^2 + 1^2                2
 * 6 = 2^2 + 1^2 + 1^2          3
 * 7 = 2^2 + 1^2 + 1^2 + 1^2    4
 * 8 = 2^2 + 2^2                2
 * 9 = 3^2                      1
 */
fun main() {
    val n = readln().toInt()
    val arr = IntArray(n + 1)
    arr[1] = 1

    var min: Int
    for (i in 2..n) {
        min = Int.MAX_VALUE

        var j = 1
        while (j * j <= i) {
            val tmp = i - j * j
            if (arr[tmp] < min) min = arr[tmp]
            j++
        }

        arr[i] = min + 1
    }

    println(arr[n])
}