package com.formakidov.leetcodetasks.medium

/*
189. Rotate Array
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

class Solution189 {
    fun rotate(nums: IntArray, k: Int) {
        val effectiveK = k % nums.size
        if (effectiveK == 0) return

        val tmp = nums.takeLast(effectiveK)

        for (i in nums.size - 1 downTo effectiveK) {
            nums[i] = nums[i-effectiveK]
        }

        tmp.forEachIndexed { index, value ->
            nums[index] = value
        }
    }
}

private fun testSolution(numsInitial: IntArray, k: Int, expected: IntArray) {
    val nums = numsInitial.clone()
    val originalNumsForPrinting = numsInitial.contentToString()

    Solution189().rotate(nums, k)

    val resultMatches = nums.contentEquals(expected)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: nums = $originalNumsForPrinting, k = $k")
    println("Expected: ${expected.contentToString()}")
    println("Output: ${nums.contentToString()}")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(IntArray(5) { it * 2 }, 7, intArrayOf(6, 8, 0, 2, 4))
    testSolution(intArrayOf(1, 2, 3, 4), 5, intArrayOf(4, 1, 2, 3))
    testSolution(intArrayOf(1), 5, intArrayOf(1))
    testSolution(intArrayOf(1, 2), 1, intArrayOf(2, 1))
    testSolution(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3, intArrayOf(5, 6, 7, 1, 2, 3, 4))
    testSolution(intArrayOf(-1, -100, 3, 99), 2, intArrayOf(3, 99, -1, -100))
    testSolution(intArrayOf(1, 2, 3), 0, intArrayOf(1, 2, 3))
    testSolution(intArrayOf(1, 2, 3), 3, intArrayOf(1, 2, 3))
    testSolution(IntArray(100) { it + 1 }, 10, IntArray(100) { (it + 90) % 100 + 1 })
    testSolution(intArrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE), 1, intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE, 0))
    testSolution(IntArray(100_000) { it }, 100_000, IntArray(100_000) { it })
    testSolution(IntArray(100_000) { it }, 1, IntArray(100_000) { (it + 99_999) % 100_000 })
}
