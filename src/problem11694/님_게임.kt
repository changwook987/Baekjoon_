package problem11694

import java.util.*

fun main() {
    val n = readln().toInt()

    //1이 넘는 숫자가 존재하는지 여부 조사?
    var flag = false

    val g = with(StringTokenizer(readln())) {
        var x = 0
        repeat(n) {
            nextToken().toInt().let {
                x = x xor it
                if (it > 1) flag = true
            }
        }
        x
    }

    //1이 넘는 것이 있으면 0이 아닐경우 승리
    //아니면 1이라면 승리

    //왜?

    //1이 넘는 것이 없다 -> 다음턴을 무조건 돌탑 하나를 없애야 차례를 넘겨줄 수 있다 -> 순서게임이 된다 라는건가
    /*
    5
    1 1 1 1 1

    1 xor 1 xor 1 xor 1 xor 1 = 1
    -> 후공 승리 cubelover


    4
    1 1 1 1

    1 xor 1 xor 1 xor 1 = 0
    -> 선공 승리 koosaga

    1 초과가 없으면
    개수에 따라 승리 여부 결정

    2
    1 2

    1 xor 2 = 3
    -> 선공 승리 koosaga

    2
    2 2

    2 xor 2 = 0
    -> 후공 승리 cubelover

     */

    if ((flag && g == 0) || (!flag && g == 1)) println("cubelover")
    else println("koosaga")
}