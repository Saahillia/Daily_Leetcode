/*
 * LeetCode 70 - Climbing Stairs
 *
 * Problem summary:
 * - You are climbing a staircase with n steps.
 * - You can take either 1 step or 2 steps at a time.
 * - How many distinct ways can you reach the top?
 */
public class ClimbingStairs {

    /**
     * Compute the number of distinct ways to climb n stairs.
     *
     * @param n number of steps in the staircase (n >= 1)
     * @return number of distinct ways to reach the top
     */
    public int climbStairs(int n) {
        // Handle the smallest cases directly so the loop only deals with n >= 3.
        if (n == 1) return 1;
        if (n == 2) return 2;

        // `prev2` = ways to reach step i-2, `prev1` = ways to reach step i-1.
        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        // Each step is the sum of the previous two steps, like Fibonacci.
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}