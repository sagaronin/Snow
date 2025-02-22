import java.util.Arrays;

public class MoveZeros {
    // Questions
    /*
     * Given an integer array nums, move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.
     * 
     * Note that you must do this in-place without making a copy of the array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */

     public static void main(String[] args) {
        int nums[]={2,0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("Moved zeros: "+Arrays.toString(nums));
     }
     public static void moveZeroes(int []nums){
        int l=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i]=nums[l];
                nums[l]=temp;
                l++;
            }
        }
     }
}
