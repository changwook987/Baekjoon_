package kotlinFile

// ~+ ㅋㅋㅋㅋㅋㅋㅋㅋㅋ

import java.util.*

fun main() {
    val token = StringTokenizer(readLine())


    var a = token.nextToken()
    var b = token.nextToken()

    if(a.length > b.length){
        b = b.padStart(a.length,'0')
    }else if(b.length > a.length){
        a = a.padStart(b.length,'0')
    }

    var carry = 0
    var result = ""

    for(i in a.length.minus(1) downTo 0){
        val tmp = a[i].toString().toInt() + b[i].toString().toInt() + carry
        carry = tmp/10
        result = tmp.mod(10).toString() + result
    }
    if(carry != 0) print(carry)
    println(result)
}