/*
 * LeetCode 1 - Two Sum
 *
 * Problem summary:
 * - Given an integer array `nums` and a target value, return indices of
 *   the two numbers such that they add up to `target`.
 * - You may assume that each input has exactly one solution.
 * - You may not use the same element twice.
 */
public class TwoSum {
    /**
     * Find two indices whose values sum to target.
     *
     * @param nums input array of integers
     * @param target desired sum of two elements
     * @return a two-element array with the indices of the matching pair, or
     *         null if none found
     */
    public int[] twoSum(int[] nums, int target) {
        // Try every possible distance between the two indices.
        // This is simple to read, but it is O(n^2).
        for (int i = 1; i < nums.length; i++) {
            // `j` is the right index, and `j - i` is the left index.
            for (int j = i; j < nums.length; j++) {
                // When the two values add up to the target, return both indices.
                if (nums[j] + nums[j - i] == target) {
                    return new int[] {j, j - i};
                }
            }
        }
        return null;
    }
}