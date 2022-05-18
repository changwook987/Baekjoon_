package problem12865

import java.util.*
import kotlin.math.max

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val (n, k) = read()
    val dp = List(n + 1) { IntArray(k + 1) }

    val items = List(n) {
        val (weight, value) = read()
        weight to value
    }

    for (i in 1..n) {
        for (j in 1..k) {
            val (weight, value) = items[i - 1]

            /**
             * 현재 있는 곳은 j까지의 무게를 담은 배낭의 최대 가치
             * j < weight 이 물건의 무게가 지금 배낭에 담을 수 있는지
             * true -> 담을 수 없음 그러므로 전 아이템의 무게를 집어넣음
             * false -> 담을 수 있음
             *      전 아이템의 무게와 전 아이템 + 지금 가치를 더한값을 비교하여 더 좋은 것 선택
             */

            dp[i][j] = if (j < weight) dp[i - 1][j]
            else max(dp[i - 1][j], dp[i - 1][j - weight] + value)
        }
    }

    println(dp[n][k])
}