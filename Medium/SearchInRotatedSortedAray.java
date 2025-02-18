package Medium;

public class SearchInRotatedSortedAray {
    // Question
    /*
     * There is an integer array nums sorted in ascending order (with distinct
     * values).
     * 
     * Prior to being passed to your function, nums is possibly rotated at an
     * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
     * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
     * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
     * and become [4,5,6,7,0,1,2].
     * 
     * Given the array nums after the possible rotation and an integer target,
     * return the index of target if it is in nums, or -1 if it is not in nums.
     * 
     * You must write an algorithm with O(log n) runtime complexity.
     * 
     * Example 1:
     * 
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     */
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 0;
        System.out.println("Element " + target + "'s index in rotated sorted array is: " + search(arr, target));
    }

    public static int search(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            // Now figure out which half is sorted
            if (arr[low] <= arr[mid]) { // this means left half is sorted
                // Now check if tagret resides in this low->mid range
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// this means right half is sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
