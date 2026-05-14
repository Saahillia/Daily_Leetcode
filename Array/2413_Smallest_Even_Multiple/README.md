# Smallest Even Multiple

## Problem Link
LeetCode:
https://leetcode.com/problems/smallest-even-multiple/description/

## Difficulty
Easy

## Tags
Math, Number Theory

## Pattern
LCM / Divisibility

---

# Problem Understanding

We need to find the smallest positive integer that is divisible by both:
- n
- 2

In other words, we need the Least Common Multiple (LCM) of n and 2.

---

# Key Observation

- Every even number is already divisible by 2.
- So if n is even:
    answer = n

- If n is odd:
    multiply by 2 to make it divisible by both n and 2.

---

# Approach

1. Check whether n is even or odd.
2. If n is even:
      return n
3. Otherwise:
      return n * 2

---

# Dry Run

## Example 1

Input:
n = 5

5 is odd

5 × 2 = 10

Output:
10

---

## Example 2

Input:
n = 6

6 is already even

Output:
6

---

# Complexity Analysis

## Time Complexity
O(1)

## Space Complexity
O(1)

---

# Edge Cases

- n = 1
    answer = 2

- n already even
    return n directly

- Large even values
    still constant time

---

# Technique Learned

- Use divisibility properties before using complex logic.
- Sometimes mathematical observation removes need for loops.
- Always check whether problem can be simplified using parity (even/odd).

---

# Mistakes I Made

- Initially thought about finding LCM using loops/GCD.
- Later realized only 2 numbers are involved and parity simplifies the problem.

---

# Revision Trigger

If the problem involves:
- divisibility
- smallest common multiple
- even/odd optimization

Think:
- parity check
- simple math observation
- LCM simplification

---

# Final Java Solution

```java
class Solution {
    public int smallestEvenMultiple(int n) {

        // If n is already even,
        // it is divisible by both n and 2
        if (n % 2 == 0) {
            return n;
        }

        // If n is odd,
        // multiply by 2
        return n * 2;
    }
}
```

---

# Similar Problems

- GCD of Numbers
- LCM Problems
- Count Odd/Even Numbers
- Number Theory Basics