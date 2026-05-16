# Smallest Even Multiple

## Problem Link

LeetCode:
https://leetcode.com/problems/smallest-even-multiple/description/

---

## Difficulty

Easy

---

## Tags

- Math
- Number Theory
- Divisibility

---

## Pattern

LCM / Even-Odd Observation

---

# Topics Covered

- Math
- Number Theory
- LCM
- Divisibility
- Even/Odd Properties
- Mathematical Optimization
- Constant Time Solution

---

# Concepts Used

## Least Common Multiple (LCM)

We need the smallest number divisible by:
- n
- 2

This is called:

```text
LCM(n, 2)
```

---

## Even/Odd Property

- Every even number is divisible by 2
- Odd numbers are not divisible by 2

This observation simplifies the problem.

---

# Problem Understanding

We need to find the smallest positive integer that is divisible by both:
- n
- 2

In simple words:

Find the smallest even multiple of `n`.

---

# Key Observation

## Case 1 — n is Even

If `n` is already even:

```text
n % 2 == 0
```

then:
- n is divisible by itself
- n is divisible by 2

Therefore:

```text
answer = n
```

---

## Case 2 — n is Odd

If `n` is odd:

```text
n % 2 != 0
```

then multiply by 2:

```text
answer = n × 2
```

This becomes divisible by:
- n
- 2

---

# Brute Force Approach

## Idea

Start from `n`
and keep checking multiples until we find:
- divisible by n
- divisible by 2

---

## Brute Force Algorithm

1. Start from `n`
2. Check:
   - divisible by n
   - divisible by 2
3. If not:
   move to next multiple
4. Return first valid number

---

## Brute Force Complexity

### Time Complexity

```text
O(n)
```

In worst case for odd numbers.

---

### Space Complexity

```text
O(1)
```

---

# Optimization Technique

Instead of checking multiple numbers:

Use mathematical observation.

Since:
- every even number is divisible by 2

we only need parity checking.

---

# Optimal Approach

1. Check whether n is even or odd
2. If even:
   return n
3. Otherwise:
   return n * 2

---

# Dry Run

## Example 1

Input:

```text
n = 5
```

5 is odd.

Multiply by 2:

```text
5 × 2 = 10
```

10 is divisible by:
- 5
- 2

Output:

```text
10
```

---

## Example 2

Input:

```text
n = 6
```

6 is already even.

Output:

```text
6
```

---

# Visual Intuition

## Odd Number

```text
5
```

Not divisible by 2.

Multiply:

```text
5 × 2 = 10
```

Now divisible by:
- 5
- 2

---

## Even Number

```text
6
```

Already divisible by:
- 6
- 2

No extra work needed.

---

# Complexity Analysis

## Optimal Solution

### Time Complexity

```text
O(1)
```

Only one parity check.

---

### Space Complexity

```text
O(1)
```

No extra memory used.

---

# Edge Cases

## n = 1

```text
1 × 2 = 2
```

---

## n Already Even

Return directly.

---

## Large Values

Still constant time solution.

---

# Technique Learned

- Use divisibility properties before loops
- Mathematical observation can eliminate iteration
- Check parity (even/odd) first
- Simplify LCM problems using number properties

---

# Mistakes I Made

- Initially thought about:
  - loops
  - GCD
  - manual LCM calculation

- Later realized:
  only parity matters.

---

# Pattern Recognition

If problem involves:
- divisibility
- LCM
- even/odd
- smallest multiple

Think:

```text
Parity Check + Mathematical Observation
```

---

# Interview Topics Related

This problem helps build understanding of:

- Number Theory
- Divisibility
- LCM
- Mathematical Optimization
- Constant Time Thinking

---

# Companies Asking This Problem

Frequently asked in interviews at:

- :contentReference[oaicite:0]{index=0}
- :contentReference[oaicite:1]{index=1}
- :contentReference[oaicite:2]{index=2}
- :contentReference[oaicite:3]{index=3}

---

# Similar Problems

- GCD of Numbers
- LCM Problems
- Count Odd/Even Numbers
- Number Theory Basics

---

# Related Topics

- Mathematics
- Number Theory
- Bit Manipulation
- Divisibility Rules
- Modular Arithmetic

---

# Real Learning From This Problem

This problem teaches:

```text
Simple mathematical observation can completely remove brute force.
```

Instead of:
- loops
- repeated checking

We solve it using:
- parity
- divisibility properties

This is an important interview skill.

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