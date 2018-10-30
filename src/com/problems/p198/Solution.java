package com.problems.p198;

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        if(length==1){
            return nums[0];
        }
        if(length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] T = new int[length];
        T[length-1] = nums[length-1];
        T[length-2] = Math.max(nums[length-2], nums[length-1]);


        for(int i = length-3 ;i>=0;i--){
            T[i] = Math.max(T[i+1],nums[i]+T[i+2]);
        }

        return Math.max(T[0],T[1]);
    }
}
