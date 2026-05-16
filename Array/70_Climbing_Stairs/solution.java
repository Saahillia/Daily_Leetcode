/*
 * LeetCode 70 - Climbing Stairs
 *
 * Problem summary:
 * - You are climbing a staircase with n steps.
 * - You can take either 1 step or 2 steps at a time.
 * - How many distinct ways can you reach the top?
 *
 * Approach (iterative dynamic programming / Fibonacci):
 * - Let ways(i) be the number of ways to reach step i.
 * - You can reach step i from i-1 (one step) or i-2 (two steps), so
 *   ways(i) = ways(i-1) + ways(i-2).
 * - This recurrence is identical to the Fibonacci sequence with base
 *   values ways(1) = 1 and ways(2) = 2.
 * - We compute iteratively and keep only the last two values to use
 *   O(1) extra space.
 *
 * Complexity:
 * - Time: O(n) — single loop up to n.
 * - Space: O(1) — only a few integer variables.
 */
class solution {

    /**
     * Compute the number of distinct ways to climb n stairs.
     *
     * @param n number of steps in the staircase (n >= 1)
     * @return number of distinct ways to reach the top
     */
    public int climbStairs(int n) {
        // Handle the small n edge-cases directly:
        // If there's 1 step, there is only one way: [1].
        if (n == 1) return 1;
        // If there are 2 steps, there are two ways: [1+1], [2].
        if (n == 2) return 2;
        // We maintain two variables representing the previous two results:
        // prev2 = ways(i-2), prev1 = ways(i-1).
        int prev2 = 1; // ways(1)
        int prev1 = 2; // ways(2)
        int current = 0; // will hold ways(i) for the current i
        // Start from i = 3 and build up to n using the recurrence
        // ways(i) = ways(i-1) + ways(i-2).
        for (int i = 3; i <= n; i++) {
            // compute ways for current step i
            current = prev1 + prev2;
            // shift the window: the previous becomes prev2, current becomes prev1
            prev2 = prev1;
            prev1 = current;
        }
        // After the loop, `current` holds ways(n).
        return current;
    }
}