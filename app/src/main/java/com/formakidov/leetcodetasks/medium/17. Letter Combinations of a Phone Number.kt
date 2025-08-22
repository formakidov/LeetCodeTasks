package com.formakidov.leetcodetasks.medium

/*
17. Letter Combinations of a Phone Number
Medium
Topics
premium lock icon
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution17 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val map = mapOf(
            '2' to arrayOf('a','b','c'),
            '3' to arrayOf('d','e','f'),
            '4' to arrayOf('g','h','i'),
            '5' to arrayOf('j','k','l'),
            '6' to arrayOf('m','n','o'),
            '7' to arrayOf('p','q','r','s'),
            '8' to arrayOf('t','u','v'),
            '9' to arrayOf('w','x','y','z')
        )

        val combs = mutableSetOf<String>()
        combs.add("")

        digits.forEach { digit ->
            val newCombs = mutableSetOf<String>()
            map[digit]?.forEach { char ->
                combs.forEach { newCombs.add(it + char) }
            }
            combs.clear()
            combs.addAll(newCombs)
        }
        return combs.toList()
    }
}

fun main() {
    val solution = Solution17()

    fun test(digits: String, expected: List<String>) {
        val result = solution.letterCombinations(digits)
        if (result.toSet() == expected.toSet()) {
            println("✅ Test passed for input: \"$digits\". Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for input: \"$digits\". Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test("23", listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    test("", emptyList())
    test("2", listOf("a", "b", "c"))
    test("9", listOf("w", "x", "y", "z"))
}
