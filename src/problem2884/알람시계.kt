package problem2884

import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)

    var hour = scanner.nextInt()
    var minute = scanner.nextInt()-45

    hour = if(minute <= 0){
        minute += 60
        hour - 1
    }else{
        hour
    }
    hour = if(hour <= 0){
        hour + 24
    }else{
        hour
    }
    print("$hour $minute")
}