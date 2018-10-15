package com.problems.p5;

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 1;
        int minLeft = 0;
        int maxRight = 0;
        int tmpMinLeft = 0;
        int tmpMaxRight = 0;

        for (float i = 0.5F; i < len; i += 0.5) {
            int palindromeLength = (i - (int) i) > 0.1 ? 0 : 1;
            if (i - (int) i <= 0.1) {
                int index = (int) i;
                for (int j = 1; j <= index; j++) {
                    int leftIndex = index - j;
                    int rightIndex = index + j;
                    if (rightIndex > len - 1) {
                        break;
                    }

                    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                        palindromeLength += 2;

                        tmpMinLeft = leftIndex;
                        tmpMaxRight = rightIndex;

                    }else {
                        break;
                    }
                }
            } else {
                int index = (int) (2 * i);
                for (int j = 1; j <= index; j += 2) {
                    int leftIndex = (int) (i - j * 0.5);
                    int rightIndex = (int) (i + j * 0.5);
                    if (rightIndex > len - 1) {
                        break;
                    }

                    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                        palindromeLength += 2;
                        tmpMinLeft = leftIndex;
                        tmpMaxRight = rightIndex;

                    }else {
                        break;
                    }
                }
            }
            if (maxLength < palindromeLength) {
                maxLength = palindromeLength;
                minLeft = tmpMinLeft;
                maxRight = tmpMaxRight;

            }

        }
        return s.substring(minLeft, maxRight + 1);

    }


    public static void main(String[] args) {
        String s = "abcda";
        String a = new Solution().longestPalindrome(s);
        System.out.println(a);
    }
}