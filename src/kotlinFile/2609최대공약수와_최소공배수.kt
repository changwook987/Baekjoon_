package kotlinFile

fun gcd(a: Int, b: Int): Int {
    return a.mod(b).run {
        if (this == 0) {
            b
        } else {
            gcd(b, this)
        }
    }
}

val Pair<Int, Int>.gcd get() = gcd(first, second)
val Pair<Int, Int>.lcm get() = first * second / gcd

fun main() = with(java.util.Scanner(System.`in`)) {
    val a = nextInt() to nextInt()

    println(a.gcd)
    println(a.lcm)
}