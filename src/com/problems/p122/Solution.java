package com.problems.p122;


class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;


        int sumProfit = 0;
        if(len < 2){return 0;}
        int currentMinVal = prices[0];
        if(len<4){

            for(int i=1;i<len;i++){
                if(currentMinVal > prices[i]){
                    currentMinVal = prices[i];
                    //System.out.println(i+" currentMinVal= "+currentMinVal);
                }else{
                    int diff = prices[i] - currentMinVal;
                    if(diff > sumProfit){
                        sumProfit = diff;
                    }
                }
            }

            return sumProfit;
        }


        for(int i=1;i<len-1;i++){
            if(currentMinVal > prices[i]){
                currentMinVal = prices[i];
                //System.out.println(i+" currentMinVal= "+currentMinVal);
            }
            if(prices[i] >= prices[i-1] && prices[i] >= prices[i+1]){
                int diff = prices[i] - currentMinVal;
                if(diff > 0)
                    sumProfit += diff;
                //System.out.println(i+" sumProfit= "+sumProfit);
                currentMinVal = Integer.MAX_VALUE;
            }else if(i==len-2){
                int diff = prices[i+1] - currentMinVal;
                if(diff > 0)
                    sumProfit += diff;
                //System.out.println((i+1)+" sumProfit= "+sumProfit);
            }




        }
        return sumProfit;

    }
}
