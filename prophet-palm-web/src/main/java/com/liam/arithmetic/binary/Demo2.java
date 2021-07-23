package com.liam.arithmetic.binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 1、将一个数组变成二叉树
 * 2、二叉树遍历
 * Created by prophet on 2020/9/14 15:50
 */
public class Demo2 {
    public static List<Node> list = new ArrayList<>();      //用一个集合来存放每一个Node

    public void createTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i], null, null);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }
        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
    }

    // 遍历，先序遍历：根-> 左-> 右
    public static void print(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            print(node.left);
            print(node.right);
        }
    }

    // 遍历，中序遍历：左-> 根-> 右
    public static void print2(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.data + " ");
            print(node.right);
        }
    }

    // 遍历，后序遍历：左-> 右-> 根
    public static void print3(Node node) {
        if (node != null) {
            print(node.left);
            print(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Demo2 demo = new Demo2();
        demo.createTree(array);
        print(list.get(0));
        System.out.println();
        print2(list.get(0));
        System.out.println();
        print3(list.get(0));
    }

}
