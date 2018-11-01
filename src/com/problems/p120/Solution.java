package com.problems.p120;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowCount = triangle.size();

        if(rowCount<1){
            return 0;
        }
        if(rowCount<2){
            return triangle.get(0).get(0);
        }

        for(int i=rowCount-2;i>=0;i--){
            List<Integer> row = triangle.get(i);
            for(int j=0;j<row.size();j++){
                row.set(j,row.get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
