package problem1316

fun main(){
    var cnt =0
    repeat(readLine()!!.toInt()){
        val input = readLine()!!
        var check = emptyArray<Char>()

        var lastChar = ' '
        for(c in input){
            if(lastChar == c){
                continue
            }
            if(check.contains(c)){
                cnt--
                break
            }
            check = check.plus(c)
            lastChar = c
        }
        cnt++
    }
    println(cnt)
}