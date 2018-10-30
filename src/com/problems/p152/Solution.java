package com.problems.p152;

class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int maxResult = 1;
        int[] aaa = new int[length];
        for (int i = length-2; i >= 0 ; i--) {

            aaa[i] = nums[i] * nums[i+1];
        }

        for(int i =0 ;i<length;i++){
            
        }
        return 0;
    }

}
