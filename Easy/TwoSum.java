import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Questions
    /*
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * 
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * 
     * You can return the answer in any order.
     * Example 1:
     * 
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public static void main(String[] args) {
        int nums[]={2,7,11,15};
        System.out.println("Brute(indices): "+Arrays.toString(TwoSum.twoSumBrute(nums,26)));
        System.out.println("Optimal(indices): "+Arrays.toString(TwoSum.twoSumOptimal(nums,26)));
    }

    public static int[] twoSumBrute(int nums[],int target) {
        int answer[] = { 0, 0 };
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum=nums[i]+nums[j];
                if(sum==target){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        return answer;
    }

    public static int[] twoSumOptimal(int nums[],int target) {
        int answer[] = { 0, 0 };
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target -nums[i];
            if(map.containsKey(difference)){
                answer[0] = map.get(difference);
                answer[1]=i;
                return answer;
            }else{
                map.put(nums[i], i);
            }
        }
        return answer;
    }

}
