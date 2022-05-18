package problem10991

fun main(){
    val n = readLine()!!.toInt()

    for(i in 1..n){
        for(j in 0..n.minus(i.plus(1))){
            print(' ')
        }
        for(j in 0 until i.times(2).minus(1)){
            print(
                if(j.mod(2) == 0){
                    '*'
                }else{
                    ' '
                }
            )
        }
        println()
    }
}