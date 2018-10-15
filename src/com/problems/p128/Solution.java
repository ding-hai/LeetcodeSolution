package com.problems.p128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{100, 44, 101, -1, 0, 1, 2, 3,4,5, 43, 42};
        int len = new Solution().longestConsecutive(a);
        System.out.println(len);
    }

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        HashMap<Integer, Integer> nodeMap = new HashMap<>();
        HashMap<Integer, Boolean> isVisited = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int val = nums[i];
            nodeMap.put(val, val + 1);
        }

        int maxLength = 1;
        for (HashMap.Entry<Integer, Integer> entry : nodeMap.entrySet()) {
            int a = entry.getKey();
            System.out.println(a); //4 ,5, -1 0 1 2 3 100  101 5 42 43 44
            int i = 1;
            if (!isVisited.getOrDefault(a, false)) {
                Integer bVal = entry.getValue();
                do {
                    i++;
                    isVisited.put(bVal, true);
                    bVal = nodeMap.getOrDefault(bVal, null);
                }
                while (bVal != null);
                if (maxLength < i) {
                    maxLength = i;
                }
            }
        }


        return maxLength;

    }


}
