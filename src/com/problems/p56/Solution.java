package com.problems.p56;

import java.util.stream.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2){
            return intervals;
        }
        List<Interval> resultList = new ArrayList();
        Stack<Interval> stack = new Stack();
        List<Interval> sortedList = intervals.stream()
            .sorted((Interval a,Interval b)->{
                if(a.start>b.start)return 1;
                else if(a.start<b.start)return -1;
                else return 0;
            }).collect(Collectors.toList());

        if(sortedList.size()==2){
            Interval a = sortedList.get(0);
            Interval b = sortedList.get(1);

             if(a.end>=b.start){
                resultList.add(new Interval(Math.min(a.start,b.start),Math.max(a.end,b.end)));
                 return resultList;
             }
             else
                 return intervals;
        }

        stack.push(sortedList.get(0));
        for(int i=1;i<sortedList.size();i++){
            Interval a = sortedList.get(i);
            Interval temp = stack.peek();
            if(temp.end>=a.start){
                temp.end = Math.max(temp.end,a.end);
            }else{
                stack.push(a);
            }

        }

        while(stack.size()>0){
            resultList.add(stack.pop());
        }


        return resultList;

    }

}
