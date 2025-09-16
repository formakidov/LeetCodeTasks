package com.formakidov.leetcodetasks.medium

/*
80. Remove Duplicates from Sorted Array II
Medium
Topics
premium lock icon
Companies
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

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

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.
*/

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1

        var writePointer = 2

        for (readPointer in 2 until nums.size) {
            if (nums[readPointer] != nums[writePointer - 1] || nums[readPointer] != nums[writePointer - 2]) {
                nums[writePointer] = nums[readPointer]
                writePointer++
            }
        }
        return writePointer
    }
}

private fun testSolution(nums: IntArray, expectedK: Int, expectedNums: IntArray) {
    val originalNums = nums.copyOf()
    val k = try {
        Solution80().removeDuplicates(nums)
    } catch (e: NotImplementedError) {
        0
    }
    val resultMatches = k == expectedK && nums.copyOfRange(0, k).contentEquals(expectedNums)
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: ${originalNums.contentToString()}, Expected K: $expectedK, Expected Nums: ${expectedNums.contentToString()}")
    println("Output K: $k, Output Nums: ${nums.copyOfRange(0, k).contentToString()}")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}


fun main() {
    testSolution(intArrayOf(1), 1, intArrayOf(1))
    testSolution(intArrayOf(1, 1), 2, intArrayOf(1, 1))
    testSolution(intArrayOf(1, 1, 1), 2, intArrayOf(1, 1))
    testSolution(intArrayOf(1, 2, 3), 3, intArrayOf(1, 2, 3))
    testSolution(intArrayOf(1, 1, 1, 1, 1), 2, intArrayOf(1, 1))
    testSolution(intArrayOf(1, 2, 2, 2, 3), 4, intArrayOf(1, 2, 2, 3))
    testSolution(intArrayOf(1, 1, 1, 1, 1, 1), 2, intArrayOf(1, 1))
    testSolution(intArrayOf(1, 1, 2, 2, 3, 3), 6, intArrayOf(1, 1, 2, 2, 3, 3))
    testSolution(intArrayOf(1, 1, 1, 2, 2, 3), 5, intArrayOf(1, 1, 2, 2, 3))
    testSolution(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3, 3), 6, intArrayOf(1, 1, 2, 2, 3, 3))
    testSolution(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3), 7, intArrayOf(0, 0, 1, 1, 2, 3, 3))
    testSolution(intArrayOf(0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4), 10, intArrayOf(0, 0, 1, 1, 2, 2, 3, 3, 4, 4))
    testSolution(intArrayOf(1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4), 8, intArrayOf(1, 1, 2, 2, 3, 3, 4, 4))
}
