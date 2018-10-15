package com.problems.p334;

class Solution {
    public static void main(String[] args) {
        boolean flag = new Solution().increasingTriplet(new int[]{1,2,-1,-1,3});
        System.out.println(flag);
    }

    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b =  Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (number <= a) {
                a = number;
            } else if (number <= b) {
                b = number;
            }else{
                return true;
            }
            System.out.println(a+" "+b);


        }
        return false;
    }
}