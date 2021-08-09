package com.cyanflxy.leetcode.interview;

import com.cyanflxy.leetcode.help.Utils;

/**
 * @author cyanflxy
 * @since 2021.08.09
 */
public class _1003 {

    public static void main(String[] args) {
        int result;
        result = new _1003().search(Utils.toArray(1, 1, 1, 1, 1, 2, 1, 1, 1), 2);
        System.out.println(result);
        result = new _1003().search(Utils.toArray(5, 5, 5, 1, 2, 3, 4, 5), 5);
        System.out.println(result);
        result = new _1003().search(Utils.toArray(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14), 5);
        System.out.println(result);
        result = new _1003().search(Utils.toArray(15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14), 11);
        System.out.println(result);
    }

    public int search(int[] arr, int target) {
        int len = arr.length - 1;
        int l = 0;
        int h = len;

        while (l < len - 1 && arr[l + 1] == arr[l]) {
            l++;
        }
        if (l == h) {
            return arr[0] == target ? 0 : -1;
        }

        while (arr[h - 1] == arr[h]) {
            h--;
        }

        while (l < h - 1) {
            int mid = (l + h) / 2;
            if (arr[mid] > arr[0]) {
                l = mid;
            } else if (arr[mid] < arr[len]) {
                h = mid;
            }
        }
        int midIndex = h;

        l = 0;
        h = midIndex - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return findFirst(arr, mid, target);
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = midIndex;
        h = arr.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return findFirst(arr, mid, target);
            } else if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int findFirst(int[] arr, int index, int target) {
        while (index > 0 && arr[index - 1] == target) {
            index--;
        }
        return index;
    }

}
