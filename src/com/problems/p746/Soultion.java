package com.problems.p746;
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] minCostToTop = new int[len+1];

        minCostToTop[len] = 0;
        minCostToTop[len-1] = cost[len-1];

        for(int i=len-2;i>=0;i--){
            minCostToTop[i] = cost[i] + Math.min(minCostToTop[i+1],minCostToTop[i+2]);
        }

        return Math.min(minCostToTop[0],minCostToTop[1]);

    }
}
