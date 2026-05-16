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
- HashMap
- Brute Force

---

## Pattern

Hashing / Pair Sum / Lookup Optimization

---

# Topics Covered

- Arrays
- Hashing
- Brute Force
- Time Complexity Optimization
- Pair Sum Problems
- Lookup Optimization
- Nested Loop Traversal
- Space vs Time Tradeoff

---

# Concepts Used

## Brute Force Approach
Checking every possible pair in the array.

---

## HashMap Optimization
Using extra space to reduce time complexity.

---

## Complement Technique

Instead of checking every pair manually:

```text
target - currentElement
```

is searched directly using HashMap lookup.

---

# Problem Understanding

We are given:
- an integer array
- a target value

We need to return indices of two numbers such that:

```text
nums[i] + nums[j] = target
```

The same element cannot be used twice.

---

# Key Observation

Every possible pair can be checked using nested loops.

This solution uses:
- outer loop for distance between elements
- inner loop for checking pairs

Instead of directly using:

```text
(i, j)
```

the solution checks:

```text
(j, j - i)
```

This still covers all valid pairs.

---

# Brute Force Approach

## Idea

Check all possible pairs.

If pair sum equals target:
return indices.

---

## Approach

1. Start outer loop from `i = 1`
2. Treat `i` as distance between indices
3. Traverse array using `j`
4. Check:

```text
nums[j] + nums[j - i]
```

5. If target found:
   return indices

---

# Dry Run

Input:

```text
nums = [2,7,11,15]
target = 9
```

---

## Outer Loop

```text
i = 1
```

---

## Inner Loop

```text
j = 1
```

Check:

```text
nums[1] + nums[0]
= 7 + 2
= 9
```

Target found.

Return:

```text
[1,0]
```

---

# Complexity Analysis

## Brute Force Solution

### Time Complexity

```text
O(n²)
```

Because nested loops check all pairs.

---

### Space Complexity

```text
O(1)
```

No extra data structure used.

---

# Edge Cases

## Duplicate Values

```text
nums = [3,3]
target = 6
```

---

## Negative Numbers

```text
nums = [-1,-2,-3,-4]
target = -6
```

---

## Minimum Array Size

```text
nums = [1,2]
```

---

# Mistakes I Made

- Initially confusing loop structure
- Harder readability compared to standard brute force
- Forgot that pair traversal can be simplified

---

# Optimization Techniques

This problem can be optimized using:

## HashMap

Instead of checking all pairs manually:

Store previously seen elements.

Then search complement directly.

---

# Optimized Approach

For every element:

```text
complement = target - currentElement
```

Check whether complement already exists.

If yes:
answer found.

---

# Optimized Complexity

## Time Complexity

```text
O(n)
```

---

## Space Complexity

```text
O(n)
```

---

# Technique Learned

- Brute force pair checking
- HashMap lookup optimization
- Complement searching
- Space vs Time tradeoff

---

# Pattern Recognition

If problem contains:
- pair finding
- target sum
- complement
- repeated searching
- fast lookup

Think:

```text
HashMap / Hashing
```

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

# Similar Problems

- 3Sum
- 4Sum
- Two Sum II
- Subarray Sum Equals K
- Contains Duplicate

---

# Real Learning From This Problem

This problem is not just about arrays.

It teaches:

```text
How to optimize searching using hashing.
```

This concept appears repeatedly in:
- Arrays
- Strings
- Sliding Window
- Prefix Sum
- Graphs
- Dynamic Programming

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