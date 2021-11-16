package kotlinFile

fun main() = println(readLine()!!.plus("1234567890").groupingBy { it }.eachCount().run { listOf(get('0')!!, get('1')!!, get('2')!!, get('3')!!, get('4')!!, get('5')!!, (get('6')!! + get('9')!!).run { if(this.mod(2) == 0) this.div(2)else this.div(2).plus(1) }, get('7')!!, get('8')!!,) }.maxOf { it }.minus(1))