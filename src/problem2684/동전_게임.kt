package problem2684

fun main() {
    repeat(readln().toInt()) {
        var i = 0
        var cur = 0
        val arr = IntArray(8)

        for (c in readln()) {
            i++
            cur = cur shl 1

            if (c == 'H') {
                cur++
            }

            if (i > 2) arr[cur and 7]++
        }

        println(arr.joinToString(" "))
    }
}