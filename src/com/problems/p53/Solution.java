package com.problems.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }

        int maxValue = nums[len-1];
        for(int i = len-2;i>=0;i--){
            nums[i] = nums[i] + Math.max(0,nums[i+1]);
            if(nums[i]>maxValue){
                maxValue = nums[i];
            }
        }
        return maxValue;
    }
}
