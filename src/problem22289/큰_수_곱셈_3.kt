package problem22289

import algorithm.FFT.P
import algorithm.FFT.fft
import algorithm.FFT.nearPow2

fun main() {
    val (a, b) = readln().split(" ").map { it.map(Char::digitToInt).reversed().toIntArray() }

    val len = maxOf(a.size, b.size).nearPow2 shl 1

    val fftA = a.copyOf(len)
    val fftB = b.copyOf(len)

    fft(fftA, false)
    fft(fftB, false)

    repeat(len) { fftA[it] = (fftA[it].toLong() * fftB[it] % P).toInt() }

    fft(fftA, true)

    var cur = 0

    for ((j, i) in fftA.withIndex()) {
        cur /= 10
        cur += i

        fftA[j] = cur % 10
    }


    System.out.bufferedWriter().use {

        var flag = false

        for (i in fftA.size - 1 downTo 0) {
            if (!flag) {
                if (fftA[i] != 0) flag = true
                else continue
            }

            it.append("${fftA[i]}")
        }

        if (!flag) it.append("0")

        it.flush()
    }
}