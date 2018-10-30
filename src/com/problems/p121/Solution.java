package com.problems.p121;
/**
* 目的是求后面的减去前面的最大的差值
* 那么如果知道当前值减去前面的所有数值的最大差值，那么就可以求出结果
* 当前值减去前面的所有值可以
* 5 10  1 3 7  3 4 6 9
*  5 -9  2 4 -4 1 2 3
*  4 -1  8 6  2 6 5 3
* max : 8
*/
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length ;
        if(len<2){
            return 0;
        }else if(len==2){
            if(prices[0]<prices[1]){
                return prices[1]-prices[0];
            }else{
                return 0;
            }
        }

        int maxValue = 0;
        for(int i=prices.length-1;i>0;i--){
            prices[i] = prices[i] -  prices[i-1] ;
            System.out.print(prices[i]+"\t");
        }

        for(int i=prices.length-2;i>0;i--){
            if(prices[i+1] > 0 ){
                prices[i] += prices[i+1];

            }

        }
        for(int i=prices.length-1;i>0;i--){
            if(maxValue<prices[i]){
                    maxValue = prices[i];
            }
        }

        return maxValue;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length ;
        if(len<2){
            return 0;
        }else if(len==2){
            if(prices[0]<prices[1]){
                return prices[1]-prices[0];
            }else{
                return 0;
            }
        }


        int minCurrentValue = Integer.MIN_VALUE;
        int maxCurrentProfit = 0;
        for(int i=0;i<len;i++){
            int price = prices[i];;
            int diff = price - minCurrentValue;
            if(price<minCurrentValue){
                minCurrentValue = price;
            }else{
                if(maxCurrentProfit<diff){
                    maxCurrentProfit = diff;
                }
            }


        }



        return maxCurrentProfit;
    }
}
