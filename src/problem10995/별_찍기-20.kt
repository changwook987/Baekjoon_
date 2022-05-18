package problem10995

fun main(){
    val n = readLine()!!.toInt()

    for(i in 1..n){
        if(i.mod(2) == 0) print(' ')
        for(j in 0 until n){
            print("* ")
        }
        println()
    }
}