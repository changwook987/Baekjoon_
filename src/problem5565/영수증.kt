package problem5565

fun main(){
    var a = readLine()!!.toInt()
    repeat(9){a-= readLine()!!.toInt()}
    println(a)
}