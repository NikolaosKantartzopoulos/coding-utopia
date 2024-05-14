package problems;

//https://leetcode.com/problems/container-with-most-water/description/
// Space O(1) - Time O(n)
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
