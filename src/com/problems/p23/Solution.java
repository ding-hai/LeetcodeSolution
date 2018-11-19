package com.problems.p23;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len==1){
            return lists[0];
        }
        if(len==0){
            return null;
        }

        ListNode[] tmpList = lists;
        while(tmpList.length>1){
            int tmpLen = tmpList.length;
            int nextLen = (tmpLen+1)/2;
            ListNode[] nextLists = new ListNode[nextLen];
            for(int i=0;i<tmpLen/2;i++){
                nextLists[i] = merge2Lists(tmpList[i*2],tmpList[i*2+1]);
            }
            if(tmpLen/2<nextLen){
                nextLists[nextLen-1]=tmpList[tmpLen-1];
            }
            tmpList=nextLists;
        }
        return tmpList[0];


    }




    public ListNode merge2Lists(ListNode aListHeader,ListNode bListHeader){
        if(bListHeader==null)return aListHeader;
        if(aListHeader==null)return bListHeader;

        ListNode cListHeader = null;
        ListNode cListTail = null;

        ListNode aTmpNode = aListHeader;
        ListNode bTmpNode = bListHeader;


        //把bList合并到aList中
        while(aTmpNode!=null && bTmpNode!=null){

            if(aTmpNode.val<bTmpNode.val){
                if(cListHeader==null){
                    cListHeader = new ListNode(aTmpNode.val);
                    cListTail = cListHeader;

                }else{
                    ListNode cTmp = new ListNode(aTmpNode.val);
                    cListTail.next = cTmp;
                    cListTail=cTmp;
                }
                aTmpNode = aTmpNode.next;
            }else{
                if(cListHeader==null){
                    cListHeader = new ListNode(bTmpNode.val);
                    cListTail = cListHeader;

                }else{
                    ListNode cTmp = new ListNode(bTmpNode.val);
                    cListTail.next = cTmp;
                    cListTail=cTmp;
                }
                bTmpNode = bTmpNode.next;
            }
        }

        if(bTmpNode!=null){
            cListTail.next=bTmpNode;
        }

        if(aTmpNode!=null){
            cListTail.next=aTmpNode;
        }

        return cListHeader;

    }
}
