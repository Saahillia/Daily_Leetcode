# Two Sum

## Problem Link

LeetCode:
https://leetcode.com/problems/two-sum/description/

---

## Difficulty

Easy

---

## Tags

- Array
- Brute Force

---

---

# Topics Covered

- Arrays
- Hashing
- Brute Force
- Time Complexity Optimization
- Pair Sum Problems
- Lookup Optimization
- Nested Loop Traversal

---

# Concepts Used

## Brute Force Approach
Checking every possible pair in the array.

## HashMap Optimization
Using extra space to reduce time complexity.

## Complement Technique
Finding:

target - currentElement

instead of checking every pair manually.

---

# Interview Topics Related

This problem helps build understanding of:

- Hashing
- Arrays
- Complexity Optimization
- Space vs Time Tradeoff
- Problem Pattern Recognition

---

# Companies Asking This Problem

Frequently asked in interviews at:

- :contentReference[oaicite:0]{index=0}
- :contentReference[oaicite:1]{index=1}
- :contentReference[oaicite:2]{index=2}
- :contentReference[oaicite:3]{index=3}
- :contentReference[oaicite:4]{index=4}
- :contentReference[oaicite:5]{index=5}
- :contentReference[oaicite:6]{index=6}
- :contentReference[oaicite:7]{index=7}

---

# Important Interview Learning

This problem teaches one of the most important coding interview concepts:

```text
Using extra memory to optimize searching.
```

Brute Force:

O(n²)

Optimized HashMap Solution:

O(n)

---

# Pattern Recognition

If problem contains:
- target sum
- pair finding
- fast searching
- repeated lookup
- complement

Possible pattern:

```text
HashMap / Hashing
```

---

# Optimization Journey

## Step 1 — Brute Force

Use nested loops.

Time Complexity:
O(n²)

---

## Step 2 — Optimized

Use HashMap.

Time Complexity:
O(n)

---

# Real World Learning

This problem improves:
- logical thinking
- optimization skills
- interview intuition
- pattern recognition ability

## Pattern

Nested Loop Pair Checking

---

# Problem Understanding

We are given:
- an integer array
- a target value

We need to return indices of two numbers such that:

nums[i] + nums[j] = target

The same element cannot be used twice.

---

# Key Observation

Every possible pair must be checked.

This solution uses:
- outer loop for distance between elements
- inner loop for checking pairs

Instead of directly using:
(i, j)

the solution checks:

(j, j - i)

This still covers all valid pairs.

---

# Approach

1. Start outer loop from i = 1
2. Treat i as distance between indices
3. Traverse array using j
4. Check:

nums[j] + nums[j - i]

5. If target found:
      return indices

---

# Dry Run

Input:

nums = [2,7,11,15]
target = 9

Outer Loop:

i = 1

Inner Loop:

j = 1

nums[1] + nums[0]
= 7 + 2
= 9

Return:
[1,0]

---

# Complexity Analysis

## Time Complexity

O(n²)

Because nested loops are used.

---

## Space Complexity

O(1)

No extra data structure used.

---

# Edge Cases

- Array contains duplicate values
- Negative numbers
- Solution always guaranteed

---

# Technique Learned

- Brute force pair checking
- Different ways to traverse array pairs
- Using index distance traversal

---

# Mistakes I Made

- Initially confusing loop structure
- Harder readability compared to standard brute force

---

# Better Optimization

This problem can be optimized using:

HashMap

Time Complexity becomes:

O(n)

instead of:

O(n²)

---

# Revision Trigger

If problem involves:
- pair finding
- checking all combinations
- target sum

Think:
- nested loops
- HashMap optimization

---

# Final Java Solution

```java
class Solution {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 1; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                if (nums[j] + nums[j - i] == target) {

                    return new int[] { j, j - i };
                }
            }
        }

        return null;
    }
}
```