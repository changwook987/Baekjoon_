package kotlinFile

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }

    infix fun Long.power(ex: Long): Long {
        return (if (ex == 1L) this
        else (this power (ex / 2)).let {
            (it * it).let { value ->
                if (ex % 2 == 1L) value.mod(c) * this
                else value
            }
        }).mod(c)
    }

    println(a power b)
}