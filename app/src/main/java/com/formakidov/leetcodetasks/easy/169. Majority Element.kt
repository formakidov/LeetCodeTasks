package com.formakidov.leetcodetasks.easy

/*
169. Majority Element
Easy
Topics
premium lock icon
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        // using Boyer - Moore algorithm
        var counter = 0
        var curr = 0
        nums.forEach { num ->
            if (counter == 0) {
                curr = num
                counter++
            } else if (curr == num) {
                counter++
            } else {
                counter--
            }
        }
        return curr
    }

// hashmap is obvious, but not optiomal

//    fun majorityElement(nums: IntArray): Int {
//        // majority el-t is always in the middle of sorted array
//        nums.sort()
//        return nums[nums.size / 2]
//    }
}

fun main() {
    val solution = Solution169()

    fun test(nums: IntArray, expected: Int) {
        val result = solution.majorityElement(nums)
        if (result == expected) {
            println("✅ Test passed for input: ${nums.contentToString()}. Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for input: ${nums.contentToString()}. Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test(intArrayOf(3, 2, 3), 3)
    test(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2)
    test(intArrayOf(1), 1)
    test(intArrayOf(1, 1), 1)
    test(intArrayOf(1, 2, 1), 1)
    test(intArrayOf(6, 5, 5), 5)
    test(intArrayOf(7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7), 7)
    test(intArrayOf(-1, 100, 2, 100, 100, 4, 100), 100)
    test(intArrayOf(-1, -1, -1, 0, 1), -1)
    test(intArrayOf(0, 0, 0, 1, 1), 0)
    test(intArrayOf(1000000000, 1000000000, -1000000000), 1000000000)
    test(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2), 1)
    test(intArrayOf(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 1)

}
