package com.liam.arithmetic.binary;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:节点
 * Created by prophet on 2020/9/14 15:50
 */
@Data
@AllArgsConstructor
public class Node {
    public int data;      //自己本身值
    public Node left;     //左结点
    public Node right;     //右结点

}
