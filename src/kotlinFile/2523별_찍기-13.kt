package kotlinFile

fun main(){
    val n = readLine()!!.toInt()

    for(i in 1..n){
        for(j in 1..i){
            print('*')
        }
        println()
    }
    for(i in n.minus(1) downTo 0){
        for(j in 1..i){
            print('*')
        }
        println()
    }
}