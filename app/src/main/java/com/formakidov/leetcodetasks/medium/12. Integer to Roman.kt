package com.formakidov.leetcodetasks.medium

/*
12. Integer to Roman
Medium
Topics
premium lock icon
Companies
Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.

 

Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
 8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
 900 = CM
  90 = XC
   4 = IV


Constraints:

1 <= num <= 3999
*/

class Solution12 {
    fun intToRoman(num: Int): String {
        // divide by 1000, append M as many times as resulting int

        // then take the remainder and divide by 100
        // then if the rest is >= 5:
        //      1: the rest is >= 9, append CM (e.g. 900 is CM)
        //      2: the rest is < 9: append D and as many C as there are hundreds left after subtracting 500. (e.g. 800 is DCCC or 600 is DC or 100 is C)
        // else if the rest is < 5:
        //      1: the rest is >= 4, append CD (e.g. 400 is CD)
        //      2: the rest is < 4: append as many C as there are hundreds left (e.g. 300 is CCC)

        // then take the remainder and divide by 10
        // then if the rest is >= 5:
        //      1: the rest is >= 9, append XC (e.g. 90 is XC)
        //      2: the rest is < 9: append L and as many X as there are tens left after subtracting 50. (e.g. 80 is LXXX or 60 is LX or 10 is X)
        // else if the rest is < 5:
        //      1: the rest is >= 4, append XL (e.g. 40 is XL)
        //      2: the rest is < 4: append as many X as there are tens left (e.g. 30 is XXX)

        // then take the remainder
        // then if the rest is >= 5:
        //      1: the rest is >= 9, append IX (e.g. 9 is IX)
        //      2: the rest is < 9: append V and as many I as there are ones left after subtracting 5. (e.g. 8 is VIII or 6 is VI or 1 is I)
        // else if the rest is < 5:
        //      1: the rest is >= 4, append IV (e.g. 4 is IV)
        //      2: the rest is < 4: append as many I as there are ones left (e.g. 3 is III)

        fun convert(num: Int, one: String, five: String, nine: String) = when {
            num == 9 -> nine
            num >= 5 -> "$five${one.repeat(num - 5)}"
            num == 4 -> "$one$five"
            else -> one.repeat(num)
        }

        val thousands = num / 1000
        val hundreds = (num % 1000) / 100
        val tens = (num % 100) / 10
        val ones = num % 10

        return StringBuilder().apply {
            (1..thousands).forEach { i -> append("M") }
            append(convert(hundreds, "C", "D", "CM"))
            append(convert(tens, "X", "L", "XC"))
            append(convert(ones, "I", "V", "IX"))
        }.toString()
    }
}

fun main() {
    testIntToRoman(3749, "MMMDCCXLIX")
    testIntToRoman(1994, "MCMXCIV")
    testIntToRoman(3999, "MMMCMXCIX")
    testIntToRoman(3, "III")
    testIntToRoman(58, "LVIII")
    testIntToRoman(4, "IV")
    testIntToRoman(9, "IX")
    testIntToRoman(1, "I")
    testIntToRoman(10, "X")
    testIntToRoman(100, "C")
    testIntToRoman(1000, "M")
    testIntToRoman(40, "XL")
    testIntToRoman(90, "XC")
    testIntToRoman(400, "CD")
    testIntToRoman(900, "CM")
    testIntToRoman(444, "CDXLIV")
    testIntToRoman(999, "CMXCIX")
}

private fun testIntToRoman(num: Int, expected: String) {
    val solution = Solution12()
    val result = solution.intToRoman(num)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input $num, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input $num, expected $expected, got $result"
        )
    }
}
