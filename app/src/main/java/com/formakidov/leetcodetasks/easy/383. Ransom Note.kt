package com.formakidov.leetcodetasks.easy

/*
383. Ransom Note
Easy
Topics
premium lock icon
Companies
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
*/

class Solution383 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val letters = IntArray(26)

        for (c in magazine) {
            letters[c - 'a']++
        }

        for (c in ransomNote) {
            if (--letters[c - 'a'] < 0) return false
        }

        return true
    }
}

private fun testSolution(ransomNote: String, magazine: String, expected: Boolean) {
    val result = Solution383().canConstruct(ransomNote, magazine)
    val resultMatches = result == expected
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: ransomNote = \"$ransomNote\", magazine = \"$magazine\"")
    println("Expected: $expected")
    println("Output: $result")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution("a", "b", false)
    testSolution("aa", "ab", false)
    testSolution("aa", "aab", true)
    testSolution("a", "a", true)
    testSolution("world", "odlrw", true)
    testSolution("hello", "oleh", false)
    testSolution("abcdef", "abcdef", true)
    testSolution("abcdef", "fedcba", true)
    testSolution("abcdef", "fedcb", false)
    testSolution("fihjjjjei", "hjibagacbhadfaefdjaeaebgi", false)
}
