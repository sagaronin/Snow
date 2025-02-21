package Medium;

import java.util.Arrays;

public class ReverseArrayByKPlaces {
    // Question
    /*
     * Given an integer array nums, rotate the array to the right by k steps, where
     * k is non-negative.
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     */
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 4;
        // reverseBrute(arr,k);
        // System.out.println("Revered by k="+k+" places(Brute):
        // "+Arrays.toString(arr));
        // reversBetter(arr, k);
        // System.out.println("Revered by k="+k+" places(Better):
        // "+Arrays.toString(arr));
        reversOptimal(arr, k);
        System.out.println("Revered by k=" + k + " places(Optimal): " + Arrays.toString(arr));
    }

    // Time complexity O(n^2), space complexity O(1)
    public static void reverseBrute(int arr[], int k) {
        int previous;
        for (int i = 0; i < k; i++) {
            previous = arr[arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j];
                arr[j] = previous;
                previous = temp;
            }
        }
    }

    // Time complexity O(n), space complexity O(n)
    public static void reversBetter(int arr[], int k) {
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[(i + k) % arr.length] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    // Time complexity O(n), space complexity O(1)
    public static void reversOptimal(int arr[], int k) {
        k = k % arr.length;
        // Reverse whole array
        swap(arr, 0, arr.length - 1);
        // Reverse fist k elements
        swap(arr, 0, k - 1);
        // reverse last k elements
        swap(arr, k, arr.length - 1);

    }

    public static void swap(int arr[], int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
