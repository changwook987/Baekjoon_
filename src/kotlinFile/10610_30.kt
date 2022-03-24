package kotlinFile

fun main() {
    val n = readLine()!!
    fun String.addAll(): Int {
        var cnt = 0
        for (i in this) {
            cnt += i.digitToInt()
        }
        return cnt
    }
    println(
        if (n == "30") n
        else {
            val num = n.toCharArray().sortedWith(compareBy({ it != '0' }, { it.digitToInt() })).reversed()
                .joinToString("")

            if (num.dropLast(1).addAll().mod(3) == 0 && num.last() == '0')
                num
            else -1
        }
    )
}

