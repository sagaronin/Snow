package Medium;

public class SingleElementInSortedArray {
    // Question
    /*
     * You are given a sorted array consisting of only integers where every element
     * appears exactly twice, except for one element which appears exactly once.
     * 
     * Return the single element that appears only once.
     * 
     * Your solution must run in O(log n) time and O(1) space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,1,2,3,3,4,4,8,8]
     * Output: 2
     */
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        System.out.println("Single element in array is: " + searchSingleElement(arr));
    }

    public static int searchSingleElement(int arr[]) {
        // If length of array is even then there is no single element
        if (arr.length % 2 == 0) {
            System.out.println("Array is of even length, hence single element doesnt exists");
            return -1;
        }

        // Check for boundaries
        // If starting element is single element
        if (arr[0] != arr[1]) {
            System.out.println("Starting element is single element");
            return arr[0];
        }
        // If ending element is single element
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println("Ending element is single element");
            return arr[arr.length - 1];
        }

        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // check if mid element is single element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            } else if (((mid % 2 == 1) && arr[mid - 1] == arr[mid]) || ((mid % 2 == 0) && arr[mid + 1] == arr[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            //((mid % 2 == 1) && arr[mid - 1] == arr[mid]) this denotes that mid index is odd,
            // hence element to the left of it could be equal
            //((mid % 2 == 0) && arr[mid + 1] == arr[mid] this denotes that mid index is even,
            // hence element to the right of it could be equal

        }
        return -1;
    }
}
