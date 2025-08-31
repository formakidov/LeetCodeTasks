package com.formakidov.leetcodetasks.easy

import kotlin.math.max

/*
485. Max Consecutive Ones
Easy
Topics
premium lock icon
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array.



Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

class Solution485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxOnes = 0
        var count = 0
        nums.forEach {
            if (it == 1) {
                count++
            } else if (it == 0) {
                maxOnes = max(maxOnes, count)
                count = 0
            }
        }
        return max(maxOnes, count)
    }
}

fun main() {
    testFindMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1), 3)
    testFindMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0, 1), 2)
    testFindMaxConsecutiveOnes(intArrayOf(0, 0, 0, 0), 0)
    testFindMaxConsecutiveOnes(intArrayOf(1, 1, 1, 1, 1), 5)
    testFindMaxConsecutiveOnes(intArrayOf(0), 0)
    testFindMaxConsecutiveOnes(intArrayOf(1), 1)
}

private fun testFindMaxConsecutiveOnes(nums: IntArray, expected: Int) {
    val solution = Solution485()
    val result = solution.findMaxConsecutiveOnes(nums)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input ${nums.contentToString()}, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input ${nums.contentToString()}, expected $expected, got $result"
        )
    }
}
