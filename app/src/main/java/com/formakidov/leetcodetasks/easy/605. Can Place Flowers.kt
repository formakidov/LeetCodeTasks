package com.formakidov.leetcodetasks.easy

/*
605. Can Place Flowers
Easy
Topics
premium lock icon
Companies
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */

class Solution605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = n
        var i = 0
        while (i < flowerbed.size) {
            if (flowerbed[i] == 0
                // check if first or next is 0
                && (i == 0 || flowerbed[i - 1] == 0)
                // check if last or next is 0
                && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1
                count--
            }
            if (count <= 0) {
                return true
            }
            i++
        }
        return false
    }
}

fun main() {
    testCanPlaceFlowers(intArrayOf(0, 0, 1, 0, 1, 0, 0), 2, true)
    testCanPlaceFlowers(intArrayOf(0, 1, 0, 1, 0, 1, 0, 1, 0), 1, false)

    testCanPlaceFlowers(intArrayOf(0, 0, 1, 0, 0), 1, true)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 0), 3, false)
    testCanPlaceFlowers(intArrayOf(0, 0, 0, 0, 0, 1), 2, true)
    testCanPlaceFlowers(intArrayOf(1, 0, 1, 0, 1, 0, 1), 1, false)
    testCanPlaceFlowers(intArrayOf(0, 0, 0), 2, true)
    testCanPlaceFlowers(intArrayOf(0, 0, 0, 0, 0), 3, true)
    testCanPlaceFlowers(intArrayOf(1, 1, 1, 1), 1, false)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1, true)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 1, true)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 0, 1), 2, true)
    testCanPlaceFlowers(intArrayOf(0, 0, 0, 0, 0, 0), 3, true)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2, false)
    testCanPlaceFlowers(intArrayOf(0), 1, true)
    testCanPlaceFlowers(intArrayOf(1), 0, true)
    testCanPlaceFlowers(intArrayOf(1), 1, false)
    testCanPlaceFlowers(intArrayOf(1, 0, 1, 0, 1), 0, true)
    testCanPlaceFlowers(intArrayOf(0, 0), 1, true)
    testCanPlaceFlowers(intArrayOf(0, 0), 2, false)
    testCanPlaceFlowers(intArrayOf(1, 0, 0, 0, 1, 0, 0), 1, true)
    testCanPlaceFlowers(intArrayOf(0, 0, 0, 0, 0, 0, 0), 4, true)
}

private fun testCanPlaceFlowers(flowerbed: IntArray, n: Int, expected: Boolean) {
    val solution = Solution605()
    val result = solution.canPlaceFlowers(flowerbed.clone(), n)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input ${flowerbed.contentToString()} and n=$n, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input ${flowerbed.contentToString()} and n=$n, expected $expected, got $result"
        )
    }
}
