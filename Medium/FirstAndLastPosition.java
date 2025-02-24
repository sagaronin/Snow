package Medium;

import java.util.Arrays;

public class FirstAndLastPosition {
    // Question
    /*
     * Given an array of integers nums sorted in non-decreasing order, find the
     * starting and ending position of a given target value.
     * 
     * If target is not found in the array, return [-1, -1].
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * Example 1:
     * 
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     */
    public static void main(String[] args) {
        int arr[] = { 5,7,7,8,8,10 }, target = 8;
        System.out.println("First and last occurence of an element in array is: " + Arrays.toString(searchrange(arr, target)));

    }

    public static int[] searchrange(int arr[], int target) {
        int ans[] = { -1, -1 };
        if (arr.length == 0)
            return ans;
        if (target > arr[arr.length - 1])
            return ans;
        if (target < arr[0])
            return ans;
        int firstOccurenceIndex = firstOccurence(arr, target);
        if(firstOccurenceIndex==-1){
            return ans;
        }
        int lastOccurenceIndex = lastOccurence(arr, target);
        ans[0]=firstOccurenceIndex;
        ans[1]=lastOccurenceIndex;
        return ans;
    }
    public static int firstOccurence(int arr[], int target) {
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                //This suggests keep searching in left half
                high=mid-1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int lastOccurence(int arr[], int target) {
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                //This suggests keep searching in right half
                low=mid+1;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}
