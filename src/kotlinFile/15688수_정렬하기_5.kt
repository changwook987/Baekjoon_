package kotlinFile

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()

    val arr = IntArray(2_000_001)

    repeat(r.readLine().toInt()) {
        arr[r.readLine().toInt() + 1_000_000]++
    }

    for (i in arr.indices) {
        for (j in 0 until arr[i]) {
            w.appendLine("${i - 1_000_000}")
        }
    }

    w.flush()
}