package com.problems.p_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//动态规划
//http://www.cnblogs.com/grandyang/p/4938187.html
public class Solution {
    private int[] coinValues = {1, 2, 5};

    public static void main(String[] args) {
//        int result = new Solution().minCoinNUmber(11);

        int result = new Solution().lisWithBinarySearch(new int[]{4, 2, 3, 5, 8, 1, 4, 9, 8, 11});

//        int result = new Solution().maxAppleICanGet(new int[][]{{1, 2, 3, 4, 5}, {6, 1, 1, 7, 3}, {0, 1, 2, 2, 6}});
//        Dijkstra单源最短路径
//        int result = new Solution().dijkstra(
//                new int[][]{
//                        {0, 7, 9, -1, -1, 14},
//                        {7, 0, 10, 15, -1, -1},
//                        {9, 10, 0, 11, -1, 2},
//                        {-1, 15, 11, 0, 6, -1},
//                        {-1, -1, -1, 6, 0, 9},
//                        {14, -1, 2, -1, 9, 0}},
//                4);
        System.out.println(result);
    }

    //如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元
    public int minCoinNUmber(int value) {
        int[] min = new int[value + 1];
        min[0] = 0;
        for (int i = 1; i <= value; i++) {
            //计算min[i]
            int minValue = Integer.MAX_VALUE;
            for (int coinValue : coinValues) {
                if (coinValue <= i) {
                    int maybeMin = min[i - coinValue] + 1;
                    if (minValue > maybeMin)
                        minValue = maybeMin;

                }

            }
            min[i] = minValue;

        }
        return min[value];

    }


    //最长增长子序列(可以不连续)
    public int lis(int[] numbers) {
        int maxLength = 1;
        int[] maxLengthArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            maxLengthArray[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && maxLengthArray[i] < maxLengthArray[j] + 1) {
                    maxLengthArray[i] = maxLengthArray[j] + 1;
                }
            }

            if (maxLength < maxLengthArray[i]) {
                maxLength = maxLengthArray[i];
            }
        }

        return maxLength;
    }

    //用二分查找的思想去做
    public int lisWithBinarySearch(int[] numbers) {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            if (resultList.get(0) > numbers[i]) {
                resultList.set(0, numbers[i]);
            } else if (resultList.get(resultList.size() - 1) < numbers[i]) {
                resultList.add(numbers[i]);
            } else {
                int left = 0;
                int right = resultList.size() - 1;
                int mid = 0;
                while (left < right) {
                    mid = (right - left) / 2 + left;
                    if (resultList.get(mid) > numbers[i]) {
                        left = mid;
                    } else if ((resultList.get(mid) < numbers[i])) {
                        right = mid;
                    } else {
                        break;
                    }
                }
                resultList.set(mid, numbers[i]);
            }
        }
        return resultList.size();
    }

    public int maxAppleICanGet(int[][] apples) {
        int rows = apples.length;
        int columns = apples[0].length;
        int[][] maxAppleMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int maxApple = 0;
                if (i - 1 >= 0) {
                    if (maxApple < maxAppleMatrix[i - 1][j])
                        maxApple = maxAppleMatrix[i - 1][j];
                }
                if (j - 1 >= 0) {
                    if (maxApple < maxAppleMatrix[i][j - 1])
                        maxApple = maxAppleMatrix[i][j - 1];
                }

                maxAppleMatrix[i][j] = apples[i][j] + maxApple;

            }
        }
        return 0;
    }


    public int dijkstra(int[][] map, int targetVertex) {
        int vertexCount = map.length;
        int[] minDistance = new int[vertexCount];
        int[] visitedVertex = new int[vertexCount];  //1 visited   0 not visited

        for (int i = 0; i < vertexCount; i++) {
            minDistance[i] = Integer.MAX_VALUE;
            visitedVertex[i] = 0;
        }

        minDistance[0] = 0;
        for (int i = 0; i < vertexCount; i++) {
            //遍历当前节点相邻的所有节点
            for (int j = 0; j < vertexCount; j++) {
                if (visitedVertex[i] != 1 && map[i][j] > 0 && map[i][j] + minDistance[i] < minDistance[j]) {
                    minDistance[j] = map[i][j] + minDistance[i];
                    System.out.println("更新节点1到节点" + (j + 1) + "的最短距离为" + minDistance[j]);
                }
            }
            visitedVertex[i] = 1;
            System.out.println("节点:" + (i + 1) + " out");
        }
        return minDistance[targetVertex];
    }

}



