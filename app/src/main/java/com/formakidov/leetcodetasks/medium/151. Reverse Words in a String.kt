package com.formakidov.leetcodetasks.medium

/*
151. Reverse Words in a String
Medium
Topics
premium lock icon
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 10^4
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
*/

class Solution151 {
    fun reverseWords(s: String): String {
        var foundWord = false
        var startIndex = -1
        val words = mutableListOf<String>()

        s.forEachIndexed { i, v ->
            if (v == ' ') {
                if (foundWord) {
                    words.add(s.substring(startIndex, i))
                    foundWord = false
                    startIndex = -1
                }
            } else {
                // per req-ts must be digit or number
                if (!foundWord) {
                    foundWord = true
                    startIndex = i
                }
            }

            if (foundWord && i == s.length - 1) {
                words.add(s.substring(startIndex, i + 1))
            }

        }

        val result = StringBuilder()
        for (i in words.size - 1 downTo 0) {
            result.append(words[i])
            if (i != 0) {
                result.append(' ')
            }
        }
        return result.toString()
    }
}

private fun testSolution(s: String, expected: String) {
    val result = try {
        Solution151().reverseWords(s)
    } catch (_: NotImplementedError) {
        null
    }

    val resultMatches = result == expected
    val color = if (resultMatches) "\u001B[32m" else "\u001B[31m"
    val resetColor = "\u001B[0m"
    println("${color}Input: s = \"$s\"")
    println("Expected: \"$expected\"")
    println("Output: \"$result\"")
    if (!resultMatches) {
        println("Assertion Failed!$resetColor")
    } else {
        println("Assertion Passed!$resetColor")
    }
    println("-----------------------------------------")
}

fun main() {
    testSolution("the sky is blue", "blue is sky the")
    testSolution("  hello world  ", "world hello")
    testSolution("a good   example", "example good a")
    testSolution("  Bob    Loves  Alice   ", "Alice Loves Bob")
    testSolution("Alice does not even like bob", "bob like even not does Alice")
    testSolution("a", "a")
    testSolution("  a  ", "a")
    testSolution("hello", "hello")
    testSolution("123 456", "456 123")
    testSolution("  a b c  ", "c b a")
    testSolution("singleword", "singleword")
    testSolution("  singleword  ", "singleword")
    testSolution("word with    multiple     spaces", "spaces multiple with word")
    testSolution(
        "a b c d e f g h i j k l m n o p q r s t u v w x y z",
        "z y x w v u t s r q p o n m l k j i h g f e d c b a"
    )
    testSolution("  leading and trailing spaces  ", "spaces trailing and leading")
    testSolution("  multiple   spaces   between   words  ", "words between spaces multiple")
    testSolution("a1 b2 c3", "c3 b2 a1")
    testSolution("  a1   b2   c3  ", "c3 b2 a1")
}
