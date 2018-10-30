package com.problems.p136;

class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int temp = 0;
        if (len > 0) {
            temp = nums[0];
            for (int i = 1; i < len; i++) {
                temp ^= nums[i];
            }
        }
        return temp;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(new Solution().singleNumber(nums));
    }
}
