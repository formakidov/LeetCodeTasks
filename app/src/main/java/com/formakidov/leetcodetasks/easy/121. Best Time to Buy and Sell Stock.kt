package com.formakidov.leetcodetasks.easy

/*
121. Best Time to Buy and Sell Stock
Easy
Topics
premium lock icon
Companies
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
*/

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0
        for (i in 1 until prices.size) {
            val price = prices[i]
            val diff = price - minPrice
            if (diff > maxProfit) {
                maxProfit = diff
            }
            if (price < minPrice) {
                minPrice = price
            }
        }
        return maxProfit
    }
}

private fun testSolution(prices: IntArray, expected: Int) {
    val originalPricesForPrinting = prices.contentToString()
    val result = Solution121().maxProfit(prices)

    val resultMatches = result == expected
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: prices = $originalPricesForPrinting")
    println("Expected: $expected")
    println("Output: $result")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(intArrayOf(7, 1, 5, 3, 6, 4), 5)
    testSolution(intArrayOf(7, 6, 4, 3, 1), 0)
    testSolution(intArrayOf(1, 2, 3, 4, 5), 4)
    testSolution(intArrayOf(5), 0)
    testSolution(intArrayOf(2, 4, 1), 2)
    testSolution(intArrayOf(3, 3, 3, 3), 0)
    testSolution(intArrayOf(1), 0)
    testSolution(intArrayOf(1, 0), 0)
    testSolution(intArrayOf(0, 1), 1)
    testSolution(intArrayOf(10000, 0), 0)
    testSolution(intArrayOf(0, 10000), 10000)
    testSolution(intArrayOf(2,1,2,0,1), 1)
    testSolution(intArrayOf(3,2,6,5,0,3), 4)
    testSolution(IntArray(100000) { it }, 99999)
    testSolution(IntArray(100000) { 100000 - it -1 }, 0)
    testSolution(IntArray(100000) { 1000 }, 0)
}
