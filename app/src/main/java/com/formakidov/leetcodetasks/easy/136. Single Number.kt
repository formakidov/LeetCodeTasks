package com.formakidov.leetcodetasks.easy

/*
136. Single Number
Easy
Topics
premium lock icon
Companies
Hint
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1



Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
 */

class Solution135 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        nums.forEach {
            result = result xor it
        }
        return result
    }
}

private fun testSingleNumber(nums: IntArray, expected: Int) {
    val solution = Solution135()
    val result = solution.singleNumber(nums.clone()) // Clone to avoid modification by the solution
    val status = if (result == expected) {
        "\u001B[32mPASSED\u001B[0m" // Green for PASSED
    } else {
        "\u001B[31mFAILED\u001B[0m" // Red for FAILED
    }
    println("$status - Input: ${nums.joinToString()}, Expected: $expected, Got: $result")
}

fun main() {
    // Example 1
    testSingleNumber(intArrayOf(2, 2, 1), 1)

    // Example 2
    testSingleNumber(intArrayOf(4, 1, 2, 1, 2), 4)

    // Example 3
    testSingleNumber(intArrayOf(1), 1)

    // Additional test cases
    testSingleNumber(intArrayOf(-1, -1, -2), -2)
    testSingleNumber(intArrayOf(0, 0, 5), 5)
    testSingleNumber(intArrayOf(1, 2, 3, 2, 1), 3)
    testSingleNumber(intArrayOf(10, 20, 10, 20, 30, 40, 30), 40)
}
