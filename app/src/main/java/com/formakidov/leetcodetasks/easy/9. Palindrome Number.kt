package com.formakidov.leetcodetasks.easy

/*
9. Palindrome Number
Easy

Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1

 */

fun isPalindrome(x: Int): Boolean {
    // Special cases:
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false
    }

    var revertedNumber = 0
    var num = x
    while (num > revertedNumber) {
        revertedNumber = revertedNumber * 10 + num % 10
        num /= 10
    }

    return num == revertedNumber || num == revertedNumber / 10
}

private fun test(input: Int, expected: Boolean) {
    val actual = isPalindrome(input)
    val result = if (actual == expected) "✅ PASSED" else "❌ FAILED"
    println("$input isPalindrome: $actual (Expected: $expected) -> $result")
}

fun main() {
    println("Testing Palindrome Number:")

    test(121, true)
    test(-121, false)
    test(10, false)
    test(0, true)
    test(1, true)
    test(12321, true)
    test(123, false)
}
