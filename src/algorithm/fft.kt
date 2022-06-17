package algorithm

object FFT {
    var P = 469762049
    var R = 3

    fun pow(n_: Int, exp_: Int): Int {
        var n = n_
        var exp = exp_
        var res = 1

        while (exp > 0) {
            if (exp and 1 == 1) res = (res.toLong() * n % P).toInt()
            n = (n.toLong() * n % P).toInt()
            exp = exp shr 1
        }

        return res
    }

    val Int.nearPow2: Int
        get() {
            var i = 1
            while (this > i) i = i shl 1
            return i
        }

    fun fft(a: IntArray, f: Boolean) {
        val n = a.size

        var j = 0
        for (i in 1 until n) {
            var k = n shr 1

            while (j >= k) {
                j -= k
                k = k shr 1
            }

            j += k

            if (i < j) {
                //swap
                k = a[i]
                a[i] = a[j]
                a[j] = k
            }

        }

        run {
            var i = 1
            while (i < n) {
                val x = pow(if (f) pow(R, P - 2) else R, (P / i) shr 1)
                j = 0
                while (j < n) {
                    var y = 1
                    for (k in 0 until i) {
                        val z = (a[i or j or k].toLong() * y % P).toInt()

                        a[i or j or k] = a[j or k] - z

                        if (a[i or j or k] < 0) a[i or j or k] += P
                        a[j or k] += z

                        if (a[j or k] >= P) a[j or k] -= P
                        y = (y.toLong() * x % P).toInt()
                    }

                    j += i shl 1
                }
                i = i shl 1

            }
        }

        if (f) {
            j = pow(n, P - 2)
            for (i in 0 until n) {
                a[i] = (a[i].toLong() * j % P).toInt()
            }
        }
    }
}