package com.problems.p309;

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2){
            return 0;
        }
        int[] nothold = new int[len];
        int[] hold = new int[len];

        nothold[0] = 0;
        hold[0] = -prices[0];

        for(int i=1;i<len;i++){
            nothold[i] = Math.max(hold[i-1]+prices[i],nothold[i-1]);
            int temp = 0;
            if(i>1){
                temp = nothold[i-2];
            }
            hold[i] = Math.max(hold[i-1],temp-prices[i]);
        }

        return Math.max(nothold[len-1],hold[len-1]);
    }
}
