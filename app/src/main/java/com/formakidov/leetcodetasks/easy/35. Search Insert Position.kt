package com.formakidov.leetcodetasks.easy

/*
35. Search Insert Position
Easy
Topics
premium lock icon
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

class Solution35 {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = (high + low) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }

        return low
    }
}

private fun testSearchInsert(nums: IntArray, target: Int, expected: Int) {
    val solution = Solution35()
    val result = solution.searchInsert(nums, target)
    if (result == expected) {
        println("Test passed for nums: ${nums.contentToString()}, target: $target. Expected: $expected, Got: $result")
    } else {
        val redColor = "\u001B[31m"
        val resetColor = "\u001B[0m"
        println("${redColor}Test FAILED for nums: ${nums.contentToString()}, target: $target. Expected: $expected, Got: $result$resetColor")
    }
}

fun main() {
    testSearchInsert(intArrayOf(1, 3, 5, 6), 5, 2)
    testSearchInsert(intArrayOf(1, 3, 5, 6), 2, 1)
    testSearchInsert(intArrayOf(1, 3, 5, 6), 7, 4)
    testSearchInsert(intArrayOf(1, 3, 5, 6), 0, 0)
    testSearchInsert(intArrayOf(1), 0, 0)
    testSearchInsert(intArrayOf(1), 1, 0)
    testSearchInsert(intArrayOf(1), 2, 1)
    testSearchInsert(intArrayOf(1, 3), 0, 0)
    testSearchInsert(intArrayOf(1, 3), 4, 2)
}
