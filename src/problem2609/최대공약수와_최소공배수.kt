package problem2609


fun main() = with(java.util.Scanner(System.`in`)) {
    val a = nextInt() to nextInt()

    fun gcd(a: Int, b: Int): Int {
        return a.mod(b).run {
            if (this == 0) {
                b
            } else {
                gcd(b, this)
            }
        }
    }

    gcd(a.first, a.second).let {
        println(it)
        println(a.first * a.second / it)
    }
}