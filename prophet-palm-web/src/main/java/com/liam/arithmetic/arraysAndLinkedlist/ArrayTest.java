package com.liam.arithmetic.arraysAndLinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组
 *
 * @author prophet
 * @date 2021/4/8  17:20
 */
public class ArrayTest {
    public static void main(String[] args) {
        /*
        一、找出只出现一次的数字，（注：其他重复数字只出现两次）
        答案：使用异或运算：
            异或运算：相同为0，相异为1
            任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0=a
            任何数和其自身做异或运算，结果是0，即 a ^ a=0
            异或运算满足交换律和结合律，即 a ^ b ^ a=b ^ a ^ a=b ^ (a ^ a)=b ^ 0=b
         */
        int[] ints = {2, 2, 1};
        System.out.println(mapTest2(ints));

        /*
        二、找到其中的多数元素，（注：多数元素是次数大于n/2的）
         */
        Arrays.sort(ints);
        System.out.println(ints[ints.length / 2]);

        /*
        三、编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target
        matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
         */
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        searchMatrix(matrix, 8);
        //二分查找算法
        binarysearch(new int[]{1, 3, 4, 5, 6}, 0, 4, 5);
        /*
        四、合并两个有序数组
         */
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));


    }

    public static int mapTest(int[] ints) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int anInt : ints) {
            list.add(anInt);
        }
        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(o -> {
            if (map.get(o) != null) {
                Integer count = map.get(o);
                count = count + 1;
                map.put(o, count);
            } else {
                map.put(o, 1);
            }
        });
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                return integerIntegerEntry.getKey();
            }
        }
        return 0;
    }

    //
    public static int mapTest2(int[] ints) {
        Integer single = 0;
        for (int anInt : ints) {
            single = single ^ anInt;
        }
        return single;
    }


    /*
      递归实现二分查找一纬数组
     */
    static int binarysearch(int[] array, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (array[mid] > target)
            return binarysearch(array, low, mid - 1, target);
        if (array[mid] < target)
            return binarysearch(array, mid + 1, high, target);
        return mid;
    }

    /*
     非递归实现二分查找一纬数组
    */
    static int bsearchWithoutRecursion(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;//等价于 int mid = (low + high) / 2;
            if (array[mid] > key)
                high = mid - 1;
            else if (array[mid] < key)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /*
     二分查找二纬数组
    */
    static boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

    static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;

        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }


}
