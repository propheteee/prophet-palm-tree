package com.liam.arithmetic.sort;

/**
 * Description:排序算法
 * Created by prophet on 2021/1/7 10:26
 */
public class SortTest {

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 2, 4};
        bubbling(arr);

        int[] arr1 = {5, 4, 1, 3, 6};
        choose(arr1);

    }

    //冒泡排序
    public static void bubbling(int[] arr) {
        //外层循环，遍历次数
        for (int i = 0; i < arr.length; i++) {
            //内层循环，升序（如果前一个值比后一个值大，则交换）
            //内层循环一次，获取一个最大值
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //选择排序
    public static void choose(int[] arr) {
        //选择
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无序的最小值，做替换
        }
    }

    //插入排序
    public static void insert(int[] arr) {
        //外层循环，从第二个开始比较
        for (int i = 1; i < arr.length; i++) {
            //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1] ;
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
    }
    //希尔排序
    public static void xier(int[] arr) {
        //i层循环控制步长
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //j控制无序端的起始位置
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
            //j,k为插入排序，不过步长为i
        }
    }

}
