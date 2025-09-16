package com.formakidov.leetcodetasks.easy

/*
1. Two Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/
class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>(nums.size)

        nums.forEachIndexed { index, value ->
            val remaining = target - value
            if (map.containsKey(remaining)) {
                return intArrayOf(map[remaining]!!, index)
            }
            map[value] = index
        }

        return intArrayOf() // never reaches per task specs (there is always a solution)
    }
}

fun main() {
    val solution = Solution1()

    fun test(nums: IntArray, target: Int, expected: IntArray) {
        val originalNums = nums.copyOf()
        // The user's implementation modifies the array, so we pass a copy
        val result = solution.twoSum(nums.copyOf(), target)
        
        val resultSorted = result
        val expectedSorted = expected

        if (resultSorted.contentEquals(expectedSorted)) {
            println("✅ Test passed for input: ${originalNums.contentToString()}, target = $target. Result: ${result.contentToString()}")
        } else {
            println("❌ Test FAILED for input: ${originalNums.contentToString()}, target = $target. Expected: ${expected.contentToString()}, Got: \u001B[31m${result.contentToString()}\u001B[0m.")
        }
    }

    test(intArrayOf(0, 4, 3, 0), 0, intArrayOf(0, 3))
    test(intArrayOf(3, 3), 6, intArrayOf(0, 1))
    test(intArrayOf(2, 5, 5, 11), 10, intArrayOf(1, 2))
    test(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2))
    test(intArrayOf(-1, -2, -3, -4, -5), -8, intArrayOf(2, 4))
    test(intArrayOf(-10, 7, 19, 15), 9, intArrayOf(0, 2))
    test(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1))
    test(intArrayOf(100, 200, 300, 400), 700, intArrayOf(2, 3))
}
