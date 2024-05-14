package problems;

public class ProductOfArrayExceptSelf {
    //https://leetcode.com/problems/product-of-array-except-self/description/
    // Space O(n) - Time O(n)
    public static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;

        int[] result = new int[numsLength];

        int prefixProduct = 1;
        for (int i = 0; i < numsLength; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = numsLength - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}
