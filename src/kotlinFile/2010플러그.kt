package kotlinFile

fun main(){
    var plug = 1
    repeat(readLine()!!.toInt()){
        plug += readLine()!!.toInt().minus(1)
    }
    println(plug)
}