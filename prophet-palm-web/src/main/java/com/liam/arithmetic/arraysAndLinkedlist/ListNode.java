package com.liam.arithmetic.arraysAndLinkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 链表
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 一、反转单链表 1->2->3->4->5->null  变为 1<-2<-3<-4<-5<-null
     */
    //解法一：使用数组的索引逆序进行反转 O(n)
    public static ListNode reverseList(ListNode head) {
        List<ListNode> objects = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            objects.add(cur);
            cur = cur.next;
        }
        for (int i = objects.size() - 1; i >= 0; i--) {
            ListNode listNode = objects.get(i);
            if (i == 0) {
                listNode.next = null;
            } else {
                listNode.next = objects.get(i - 1);
            }
        }
        head = objects.get(objects.size() - 1);
        return head;
    }

    //解法二、双指针迭代 O(n)
    public static ListNode reverseList2(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //记录当前节点的下一个节点
            ListNode temp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = temp;
        }
        return null;
    }

    /**
     * 二、判断链表是否有环
     */
    //解法一：使用set判断是否有重复节点O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        ListNode reverseHead = reverseList(head);


//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//        System.out.println();
//
//        ListNode[] i = new ListNode[6];
//        i[0] = listNode1;
    }
}





