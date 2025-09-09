package com.formakidov.leetcodetasks.medium

import kotlin.math.min

/*
11. Container With Most Water
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4
*/

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var maxArea = 0
        while (i < j) {
            val heightI = height[i]
            val heightJ = height[j]
            val area = min(heightI, heightJ) * (j - i)
            if (area > maxArea) {
                maxArea = area
            }
            if (heightI < heightJ) i++ else j--
        }
        return maxArea
    }
}

fun main() {
    // Examples from the task
    testMaxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49)
    testMaxArea(intArrayOf(1, 1), 1)

    // Custom test cases
    testMaxArea(intArrayOf(6, 1, 1, 1, 1, 1, 1, 7), 42) // Tallest lines at the ends
    testMaxArea(intArrayOf(1, 2, 8, 2, 1), 4) // Tallest line in the middle
    testMaxArea(intArrayOf(1, 2, 3, 4, 5, 6), 9) // Strictly increasing
    testMaxArea(intArrayOf(6, 5, 4, 3, 2, 1), 9) // Strictly decreasing
    testMaxArea(intArrayOf(5, 5, 5, 5), 15) // All same heights
    testMaxArea(intArrayOf(2, 7), 2) // Only two elements
    testMaxArea(intArrayOf(4, 3, 2, 1, 4), 16)
    testMaxArea(intArrayOf(1, 2, 1), 2)
    testMaxArea(intArrayOf(2, 3, 4, 5, 18, 17, 6), 17)
    testMaxArea(intArrayOf(1, 1, 1, 1, 100, 100, 1, 1, 1, 1), 100)
    testMaxArea(intArrayOf(0, 0, 0, 0, 0), 0) // All zeros
}

private fun testMaxArea(height: IntArray, expected: Int) {
    val solution = Solution11()
    val result = solution.maxArea(height)
    val heightStr = height.joinToString(", ", "[", "]")
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input height = $heightStr, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input height = $heightStr, expected $expected, got $result"
        )
    }
}
