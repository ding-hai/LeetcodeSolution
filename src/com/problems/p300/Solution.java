package com.problems.p300;

class Solution {
    public static void main(String[] args) {
        int result = new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(result);

    }
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] maxArray = new int[length];
        int maxValue = 1;
        for (int i = 0; i < length; i++) {
            maxArray[i] = 1;

        }
        for(int i = 1;i<length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && maxArray[j]+1>maxArray[i]){
                    maxArray[i] =  maxArray[j]+1;

                }
            }
            if(maxValue <maxArray[i]  ){
                maxValue = maxArray[i] ;
            }
        }
        return maxValue;
    }
}