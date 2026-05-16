# Climbing Stairs

## Problem Link

LeetCode:
https://leetcode.com/problems/climbing-stairs/description/

---
## Difficulty
Easy
---

## Tags
- Dynamic Programming
- Math
- Fibonacci
- Recursion
---

## Pattern
Dynamic Programming / Fibonacci Pattern
---

# Problem Understanding
We are given:

- A staircase with `n` steps
- We can climb:
  - 1 step
  - 2 steps

We need to find the total number of distinct ways to reach the top.

---

# Key Observation

To reach step `n`:

We can come from:
- step `n - 1`
- step `n - 2`

So:

```text
ways(n) = ways(n - 1) + ways(n - 2)
```

This is exactly the Fibonacci pattern.

---

# Recursive Thinking

Suppose:

```text
n = 5
```

To reach step 5:
- jump 1 step from 4
- jump 2 steps from 3

Therefore:

```text
ways(5) = ways(4) + ways(3)
```

---

# Brute Force Approach (Recursion)

## Idea

Try every possible path recursively.

At each step:
- climb 1 stair
- climb 2 stairs

---

## Recursive Formula

```text
f(n) = f(n - 1) + f(n - 2)
```

---

## Brute Force Recursive Code

```java
class Solution {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```

---

# Brute Force Complexity

## Time Complexity

```text
O(2^n)
```

Because recursive calls repeat many calculations.

---

## Space Complexity

```text
O(n)
```

Recursive stack depth.

---

# Why Brute Force Is Bad

Example:

```text
climbStairs(5)
```

will repeatedly calculate:

```text
climbStairs(3)
climbStairs(2)
```

multiple times.

This causes overlapping subproblems.

---

# Optimization Techniques

This problem can be optimized using:

## 1. Memoization (Top Down DP)

Store already computed answers.

### Complexity

Time:
```text
O(n)
```

Space:
```text
O(n)
```

---

## 2. Tabulation (Bottom Up DP)

Build answers iteratively.

### Complexity

Time:
```text
O(n)
```

Space:
```text
O(n)
```

---

## 3. Space Optimized DP (Best Solution)

Only previous two values are required.

Use:
- prev1
- prev2

instead of entire DP array.

### Complexity

Time:
```text
O(n)
```

Space:
```text
O(1)
```

---

# Optimal Approach Used

This solution uses:

```text
Space Optimized Dynamic Programming
```

Since:

```text
current = prev1 + prev2
```

Only the last two states are needed.

---

# Dry Run

## Example

```text
n = 5
```

---

Initial Values:

```text
prev2 = 1
prev1 = 2
```

---

### i = 3

```text
current = 2 + 1 = 3
```

Update:

```text
prev2 = 2
prev1 = 3
```

---

### i = 4

```text
current = 3 + 2 = 5
```

Update:

```text
prev2 = 3
prev1 = 5
```

---

### i = 5

```text
current = 5 + 3 = 8
```

Answer:

```text
8
```

---

# Visual Intuition

```text
Step 1 -> 1 way
Step 2 -> 2 ways
Step 3 -> 3 ways
Step 4 -> 5 ways
Step 5 -> 8 ways
```

Pattern:

```text
1 2 3 5 8
```

Fibonacci sequence.

---

# Complexity Analysis

## Optimal Solution

### Time Complexity

```text
O(n)
```

Single traversal.

---

### Space Complexity

```text
O(1)
```

Only variables used.

---

# Edge Cases

## n = 1

```text
1 way
```

---

## n = 2

```text
2 ways
```

---

## Small Inputs

Need base cases to avoid incorrect computation.

---

# Technique Learned

- Dynamic Programming
- Fibonacci Pattern
- Space Optimization
- Bottom-Up Computation
- State Transition

---

# Important DP Learning

This problem teaches:

```text
Current state depends on previous states.
```

DP problems often follow:

```text
dp[i] = dp[i - 1] + dp[i - 2]
```

---

# Mistakes I Made

- Initially tried recursion
- Repeated calculations caused inefficiency
- Forgot this is Fibonacci pattern
- Used extra array unnecessarily

---

# Revision Trigger

If problem involves:
- counting ways
- previous states
- overlapping subproblems
- minimum/maximum ways

Think:

```text
Dynamic Programming
```

If formula resembles:

```text
f(n) = f(n-1) + f(n-2)
```

Think:

```text
Fibonacci Pattern
```

---

# Companies Asking This Problem

Frequently asked in interviews at:

- :contentReference[oaicite:0]{index=0}
- :contentReference[oaicite:1]{index=1}
- :contentReference[oaicite:2]{index=2}
- :contentReference[oaicite:3]{index=3}
- :contentReference[oaicite:4]{index=4}
- :contentReference[oaicite:5]{index=5}

---

# Related Topics

- Dynamic Programming
- Fibonacci DP
- Recursion
- Memoization
- Tabulation
- Space Optimization

---

# Similar Problems

- Fibonacci Number
- Min Cost Climbing Stairs
- House Robber
- Decode Ways
- Coin Change

---

# Final Java Solution

```java
class Solution {

    public int climbStairs(int n) {

        if (n == 1) return 1;

        if (n == 2) return 2;

        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {

            current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
```

---

# Real Learning From This Problem

This problem is not just about stairs.

It teaches:

```text
How to optimize recursive problems using Dynamic Programming.
```

This pattern appears repeatedly in:
- DP
- Graphs
- Recursion
- Path counting problems
- Optimization problems