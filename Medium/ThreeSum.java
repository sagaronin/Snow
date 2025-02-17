package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Three sum lists are: " + threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int arr[]) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                // Skip the same pair
                continue;
            }
            int l = i + 1, r = arr.length-1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                //since array is sorted we can compare sum to zero and inc/dec the l and r pointers resp.
                if(sum<0){
                    l++;
                }else if(sum>0){
                    r--;
                }else{
                    //This means sum=0, i.e. we found pair whose sum is zero
                    ans.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                    // Skip the same pairs
                    while(l<r && arr[l]==arr[l-1]) l++;
                    while(l<r && arr[r]==arr[r+1]) r--;
                }
            }
        }
        return ans;
    }
}
