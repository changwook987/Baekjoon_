package kotlinFile

fun main(){
    val n = readLine()!!.toInt()

    for(i in 1..n){
        var str = ""
        for(j in 0 until i){
            str+='*'
        }

        print(str.padEnd(n,' '))
        println(str.padStart(n,' '))
    }
    for(i in n.minus(1) downTo 0){
        var str = ""
        for(j in 0 until i){
            str+='*'
        }

        print(str.padEnd(n,' '))
        println(str.padStart(n,' '))
    }
}