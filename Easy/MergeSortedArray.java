import java.util.Arrays;

public class MergeSortedArray {
    // Question
    /*
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
     * order, and two integers m and n, representing the number of elements in nums1
     * and nums2 respectively.
     * 
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * 
     * The final sorted array should not be returned by the function, but instead be
     * stored inside the array nums1 and nums2 in sorted order resp. 
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums1 = [1,2,3], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
     * from nums1.
     */
    public static void main(String[] args) {
        int arr1[]={1,3,5};
        int arr2[]={0,2,3,6,8};
        //mergeBrute(arr1, arr2);
        //System.out.println("Merged Arrays (Brute): "+Arrays.toString(arr1)+Arrays.toString(arr2));
        mergeOptimal1(arr1, arr2);
        System.out.println("Merged Arrays (Optimal1): "+Arrays.toString(arr1)+Arrays.toString(arr2));
    }
    public static void mergeBrute(int arr1[],int arr2[]){
        int m = arr1.length,n=arr2.length;
        int i=0,j=0,k=0;
        int answer[]=new int[n+m];
        //copy all elements until one of two arrays dries out
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                answer[k++]=arr1[i++];
            }else{
                answer[k++]=arr2[j++];
            }
        }

        //Copy remaining elements from array 1 if there are any
        while(i<m ){
            answer[k++]=arr1[i++];
        }

        //Copy remaining elements from array 2 if there are any
        while(j<n ){
            answer[k++]=arr2[j++];
        }

        //Store back the sorted elements in original arrays in sorted order
        for (int l = 0; l < n+m; l++) {
            if(l<m)
                arr1[l]=answer[l];
            else
                arr2[l-m]=answer[l];
        }

    }
    public static void mergeOptimal1(int arr1[],int arr2[]){
        int m = arr1.length,n=arr2.length;
        int left=m-1,right=0;
        // I am taking two pointers, one for arr1=left, another for arr2=right
        // What I am trying to do here is that keeping left pointer at max element of arr1
        // and right pointer at min element of arr2. After this compare if the max of arr1 is greater than low of arr2 then swap.
        // if it is not then break the loop. After that swap the individual arrays
        while(left>=0 && right<n){
            if(arr1[left]>arr2[right]){
                int temp = arr2[right];
                arr2[right]=arr1[left];
                arr1[left]=temp;
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
