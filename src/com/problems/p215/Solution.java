package com.problems.p215;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] excludeIndexs = new int[nums.length];
        int max = 0;
        for(int i=0;i<k;i++){
            int lastChangeIndex = 0;
            max =Integer.MIN_VALUE;
            for(int j=0;j<nums.length;j++){
                if(excludeIndexs[j]==0){
                    if(max<nums[j]){
                        max = nums[j];
                        lastChangeIndex = j;
                    }
                }

            }
            excludeIndexs[lastChangeIndex] = 1;

        }
        return max;
    }
}
