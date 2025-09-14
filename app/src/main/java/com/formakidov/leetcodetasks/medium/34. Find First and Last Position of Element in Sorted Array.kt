package com.formakidov.leetcodetasks.medium

/*
34. Find First and Last Position of Element in Sorted Array
Medium
Topics
premium lock icon
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
*/

class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }

        var targetStartIndex = -1
        var left = 0
        var right = nums.size - 1
        var mid: Int

        while (left <= right) {
            mid = left + (right - left) / 2

            val midValue = nums[mid]
            if (midValue == target) {
                targetStartIndex = mid
                right = mid - 1
            } else if (midValue < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        if (targetStartIndex == -1) {
            return intArrayOf(-1, -1)
        }

        var targetEndIndex = targetStartIndex
        left = targetStartIndex + 1
        right = nums.size - 1

        while (left <= right) {
            mid = left + (right - left) / 2

            val midValue = nums[mid]
            if (midValue == target) {
                targetEndIndex = mid
                left = mid + 1
            } else if (midValue < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return intArrayOf(targetStartIndex, targetEndIndex)
    }
}

fun main() {
    val solution = Solution34()

    fun test(nums: IntArray, target: Int, expected: IntArray) {
        val result = solution.searchRange(nums, target)
        if (result.contentEquals(expected)) {
            println("✅ Test passed for input: ${nums.contentToString()}, target: $target. Expected: ${expected.contentToString()}, Got: ${result.contentToString()}")
        } else {
            println("❌ Test FAILED for input: ${nums.contentToString()}, target: $target. Expected: ${expected.contentToString()}, Got: \u001B[31m${result.contentToString()}\u001B[0m")
        }
    }

    // Examples from the task
    test(intArrayOf(5, 7, 7, 8, 8, 10), 8, intArrayOf(3, 4))
    test(intArrayOf(5, 7, 7, 8, 8, 10), 6, intArrayOf(-1, -1))
    test(intArrayOf(), 0, intArrayOf(-1, -1))

    // Custom test cases
    test(intArrayOf(1, 2, 3, 4, 5), 1, intArrayOf(0, 0))
    test(intArrayOf(1, 2, 3, 4, 5), 5, intArrayOf(4, 4))
    test(intArrayOf(2, 2, 3, 4, 5), 2, intArrayOf(0, 1))
    test(intArrayOf(1, 2, 3, 4, 4), 4, intArrayOf(3, 4))
    test(intArrayOf(7, 7, 7, 7, 7), 7, intArrayOf(0, 4))
    test(intArrayOf(1, 1, 1, 1, 1, 1), 2, intArrayOf(-1, -1))
    test(intArrayOf(5), 5, intArrayOf(0, 0))
    test(intArrayOf(5), 3, intArrayOf(-1, -1))
    test(intArrayOf(2, 2), 2, intArrayOf(0, 1))

    // Target is the very first element (and has duplicates)
    test(intArrayOf(8, 8, 8, 9, 10), 8, intArrayOf(0, 2))

    // Target is the very last element (and has duplicates)
    test(intArrayOf(1, 2, 3, 8, 8, 8), 8, intArrayOf(3, 5))

    // Entire array is the target
    test(intArrayOf(8, 8, 8, 8, 8, 8), 8, intArrayOf(0, 5))

    // Target smaller than all elements
    test(intArrayOf(10, 20, 30), 5, intArrayOf(-1, -1))

    // Target larger than all elements
    test(intArrayOf(10, 20, 30), 40, intArrayOf(-1, -1))

    // Target is in the "gap" between elements
    test(intArrayOf(1, 2, 4, 5), 3, intArrayOf(-1, -1))

    // Single element array, target present
    test(intArrayOf(8), 8, intArrayOf(0, 0))

    // Single element array, target absent
    test(intArrayOf(8), 7, intArrayOf(-1, -1))

    // Two element array, first is target
    test(intArrayOf(8, 9), 8, intArrayOf(0, 0))

    // Two element array, second is target
    test(intArrayOf(7, 8), 8, intArrayOf(1, 1))

    // Long array with only one occurrence of target
    test(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 8, intArrayOf(7, 7))

    // Target is the first of two elements
    test(intArrayOf(2, 3), 2, intArrayOf(0, 0))

    // Target is the second of two elements
    test(intArrayOf(2, 3), 3, intArrayOf(1, 1))

    // Array with many duplicates of non-target values
    test(intArrayOf(1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5), 2, intArrayOf(3, 3))

    // Large numbers
    test(intArrayOf(1_000_000_000), 1_000_000_000, intArrayOf(0, 0))
}
