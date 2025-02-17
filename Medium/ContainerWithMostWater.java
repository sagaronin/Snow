package Medium;

public class ContainerWithMostWater {
    // Question
    /*
     * You are given an integer array height of length n. There are n vertical lines
     * drawn such that the two endpoints of the ith line are (i, 0) and (i,
     * height[i]).
     * 
     * Find two lines that together with the x-axis form a container, such that the
     * container contains the most water.
     * 
     * Return the maximum amount of water a container can store.
     * 
     * Notice that you may not slant the container.
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array
     * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
     * container can contain is 49.
     */
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("Area of container with max water: "+maxArea(height));
    }

    public static int maxArea(int[] heights) {
        int maxArea = 0, area = 0;
        int n = heights.length;
        int l = 0, r = n - 1;
        while (l < r) {
            //get min of both the sides of rectangle
            int height=Math.min(heights[l], heights[r]);
            //this is base of rectangle
            int base=(r-l);
            //calculate area using above two values
            area = height * base;
            maxArea = Math.max(maxArea, area);
            //whichever height of either sides is short update that variable
            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
