package kotlinFile


fun main() {

    var n = readln().toInt()

    val primes = emptyList<Int>().toMutableSet()

    fun Int.isPrime(): Boolean {
        if (primes.contains(this)) {
            return true
        } else {
            if (this < 2) return false
            var i = 2
            while (i * i <= this) {
                if (this % i == 0) return false
                i++
            }
            primes.add(this)
            return true
        }
    }

    System.out.bufferedWriter().use { w ->
        while (n != 0) {
            w.write("${List(n.times(2)) { it.plus(1) }.count { it > n && it.isPrime() }}\n")
            n = readln().toInt()
        }
        w.flush()
    }
}