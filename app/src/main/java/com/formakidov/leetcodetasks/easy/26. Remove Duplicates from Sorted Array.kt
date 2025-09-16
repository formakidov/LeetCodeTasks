package com.formakidov.leetcodetasks.easy

/*
26. Remove Duplicates from Sorted Array
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
 */


class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var writePointer = 1

        for (readPointer in 1 until nums.size) {
            if (nums[readPointer] != nums[writePointer - 1]) {
                nums[writePointer] = nums[readPointer]
                writePointer++
            }
        }
        return writePointer
    }
}
private fun testSolution(nums: IntArray, expectedK: Int, expectedNums: IntArray) {
    val originalNums = nums.copyOf()
    val k = Solution26().removeDuplicates(nums)
    val resultMatches = k == expectedK && nums.copyOfRange(0, k).contentEquals(expectedNums.copyOfRange(0, expectedK))
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: ${originalNums.contentToString()}, Expected K: $expectedK, Expected Nums: ${expectedNums.copyOfRange(0, expectedK).contentToString()}")
    println("Output K: $k, Output Nums: ${nums.copyOfRange(0, k).contentToString()}")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution(intArrayOf(1, 1, 2), 2, intArrayOf(1, 2))

    testSolution(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5, intArrayOf(0, 1, 2, 3, 4))

    testSolution(intArrayOf(1, 2, 3, 4, 5), 5, intArrayOf(1, 2, 3, 4, 5))

    testSolution(intArrayOf(1, 1, 1, 1, 1), 1, intArrayOf(1))

    testSolution(intArrayOf(-3, -3, -1, 0, 0, 0, 2, 2), 4, intArrayOf(-3, -1, 0, 2))

    testSolution(intArrayOf(5), 1, intArrayOf(5))
}
