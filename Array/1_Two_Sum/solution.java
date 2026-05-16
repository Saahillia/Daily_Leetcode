/*
 * LeetCode 1 - Two Sum
 *
 * Problem summary:
 * - Given an integer array `nums` and an integer `target`, return indices of
 *   the two numbers such that they add up to `target`.
 * - You may assume that each input would have exactly one solution.
 * - You may not use the same element twice.
 *
 * This implementation uses a simple O(n^2) brute-force approach with a
 * nested loop. The inner loop is written using an index-shift trick: for each
 * distance `i` (how far apart the two indices are), it compares elements
 * `nums[j]` and `nums[j - i]` for all valid `j`.
 *
 * Notes on readability and behavior:
 * - The method returns `null` if no pair is found; typical LeetCode
 *   constraints guarantee a solution exists, but callers should handle `null`.
 * - Time complexity: O(n^2).
 * - Space complexity: O(1) extra space.
 */
class solution {
    /**
     * Find two indices whose values sum to target.
     *
     * @param nums input array of integers
     * @param target desired sum of two elements
     * @return a two-element array with the indices of the matching pair, or
     *         null if none found
     */
    public int[] twoSum(int[] nums, int target) {
        // Outer loop: `i` represents the distance between the two indices
        // we are comparing. Start at distance 1 (adjacent elements) and go
        // up to distance nums.length-1 (first and last element).
        for (int i = 1; i < nums.length; i++) {
            // Inner loop: `j` is the right-hand index of the pair. For a
            // given distance `i`, the left index is `j - i` and must be >= 0.
            // We start `j` at `i` so that `j - i` starts at 0 and both
            // indices stay within bounds.
            for (int j = i; j < nums.length; j++) {
                // Check if the pair nums[j - i] and nums[j] sum to target.
                // This checks every unordered pair exactly once.
                if (nums[j] + nums[j - i] == target) {
                    // Return the pair of indices. The order here is
                    // [j, j - i] (right index first). If a specific order
                    // is required (e.g., smaller index first), swap them.
                    return new int[] {j, j - i};
                }
            }
        }

        // If no pair is found, return null. Under LeetCode constraints this
        // should not happen, but returning null makes the behavior explicit.
        return null;
    }
}