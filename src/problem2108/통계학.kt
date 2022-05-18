package problem2108

import kotlin.math.roundToInt

fun main() {
    //입력받은 길이의 입력받은것들의 정렬된 값
    val arr = MutableList(readLine()!!.toInt()) { readLine()!!.toInt() }.sorted()

    //평균
    println(arr.average().roundToInt())
    //중앙값
    println(arr[arr.size.minus(1).div(2)])

    //입력된 값들의 갯수들
    //예를들어 1,1,2,3,4 일경우
    // 1=2, 2=1, 3=1, 4=1
    val cnt = arr.groupingBy { it }.eachCount()

    //가장 많이 나온 값의 개수
    val maxValue = cnt.maxOf { it.value }

    //가장 많이 나온 값의 개수와 같은 개수인 것들만 추리기
    val mapKeys = cnt.filter { it.value == maxValue }.keys.sorted()

    //최빈값이 여러개일 경우 2번째로 작은 값
    println(
        if (mapKeys.size == 1) {
            mapKeys.first()
        } else {
            mapKeys[1]
        }
    )

    //범위
    println(arr.last() - arr.first())
}
