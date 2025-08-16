package com.formakidov.leetcodetasks.easy

/*
66. Plus One
Easy
Topics
premium lock icon
Companies
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
 */

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            } else {
                digits[i] = 0
            }
        }
        val newDigits = IntArray(digits.size + 1)
        newDigits[0] = 1
        return newDigits
    }
}

fun main() {
    testPlusOne(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4))
    testPlusOne(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2))
    testPlusOne(intArrayOf(9), intArrayOf(1, 0))
    testPlusOne(intArrayOf(9, 9, 9), intArrayOf(1, 0, 0, 0))
    testPlusOne(intArrayOf(1, 9, 9), intArrayOf(2, 0, 0))
    testPlusOne(intArrayOf(0), intArrayOf(1))
    testPlusOne(intArrayOf(8, 9, 9, 9), intArrayOf(9, 0, 0, 0))
}

private fun testPlusOne(digits: IntArray, expected: IntArray) {
    val initialDigits = digits.copyOf()
    val solution = Solution66()
    val result = solution.plusOne(digits)
    if (result.contentEquals(expected)) {
        println("Test passed for input ${initialDigits.contentToString()}")
    } else {
        println("\u001B[31mTest failed for input ${initialDigits.contentToString()}. Expected ${expected.contentToString()}, but got ${result.contentToString()}\u001B[0m")
    }
}
