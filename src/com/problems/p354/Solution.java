package com.problems.p354;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        //[[8,13],[17,6],[18,1],[18,2],[2,13],[19,17],[2,13],[10,7],[13,20]]
//        int[][] envelopes = {{8, 13}, {17, 6}, {18, 1}, {18, 2}, {2, 13}, {19, 17}, {2, 13}, {10, 7}, {13, 20}};
        int[][] envelopes = {{1, 2}, {2, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {5, 6}, {6, 7}, {7, 8}};
//        int result = new Solution().maxEnvelopes(envelopes);
        int result = new Solution().maxEnvelopes(envelopes);
        System.out.println(result);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (x, y) -> {
            if (x[0] > y[0]) return 1;
            if (x[0] < y[0]) return -1;
            return 0;
        });

        return lis2D(envelopes);

    }


    public int lis2D(int[][] numbers) {
        int maxLength = 1;
        int[] maxLengthArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            maxLengthArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j][0] < numbers[i][0] && numbers[j][1] < numbers[i][1] && maxLengthArray[i] < maxLengthArray[j] + 1) {
                    maxLengthArray[i] = maxLengthArray[j] + 1;
                }
            }

            if (maxLength < maxLengthArray[i]) {
                maxLength = maxLengthArray[i];
            }
        }

        return maxLength;
    }

}