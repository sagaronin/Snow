package Medium;

public class FindMinInRotatedSorted {
    // Question
    /*
     * Suppose an array of length n sorted in ascending order is rotated between 1
     * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     * 
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
     * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * 
     * Given the sorted rotated array nums of unique elements, return the minimum
     * element of this array.
     * 
     * You must write an algorithm that runs in O(log n) time.
     * Example 1:
     * 
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.F
     */
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Min Element is: " + findMin(arr));
    }

    public static int findMin(int arr[]) {
        int low = 0, high = arr.length - 1, min = Integer.MAX_VALUE;
        while (low < high) {
            int mid = (low + high) / 2;
            // find the sorted half

            if (arr[low] <= arr[mid]) {// when left half is sorted then arr[low]<=arr[mid]
                // check if arr[low] is less than min
                if (arr[low] < min)
                    min = arr[low];
                // Since we might or might not have the min element from this half, now discard this left half
                low = mid + 1;
            } else {// when right half is sorted then arr[mid]<=arr[high]
                // check if arr[mid] is less than min
                if (arr[mid] < min)
                    min = arr[mid];
                // Since we have the min element from this half, nonw discard this right half
                high = mid - 1;
            }

        }
        return min;
    }
}
