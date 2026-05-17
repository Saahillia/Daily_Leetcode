# Maximum Product Subarray

## Problem Link

LeetCode:
https://leetcode.com/problems/maximum-product-subarray/description/

---

## Difficulty

Medium

---

## Tags

- Array
- Dynamic Programming
- Greedy
- Math

---

## Pattern

Kadane’s Algorithm Variant / Dynamic Programming

---

# Topics Covered

- Arrays
- Dynamic Programming
- Maximum Subarray Problems
- Prefix Product Logic
- Negative Number Handling
- Optimization Techniques
- State Tracking

---

# Concepts Used

## Maximum Product Tracking

We need to find the contiguous subarray having the largest product.

Unlike sum problems:
- multiplication with negative numbers changes behavior
- smallest negative product can become largest positive product

---

## Dynamic State Tracking

At every position:
we track:
- current maximum product
- current minimum product

because:
- negative × negative = positive

---

## Why Minimum Product Is Important

Example:

```text
[-2, 3, -4]
```

When multiplying:

```text
(-2) × 3 × (-4) = 24
```

A negative minimum value becomes maximum later.

That is the key observation.

---

# Problem Understanding

We are given an integer array.

We need to return:

```text
maximum product of a contiguous subarray
```

Subarray must be continuous.

---

# Key Observation

For sum problems:
we usually track only maximum sum.

But for product problems:
negative numbers can flip values.

Therefore:
we must track:
- maximum product till current index
- minimum product till current index

---

# Brute Force Approach

## Idea

Generate every possible subarray.

For each subarray:
calculate product.

Store maximum product found.

---

# Brute Force Algorithm

1. Start from every index
2. Generate all subarrays
3. Calculate product
4. Update maximum answer

---

# Brute Force Dry Run

Input:

```text
nums = [2,3,-2,4]
```

Subarrays:

```text
[2] = 2
[2,3] = 6
[2,3,-2] = -12
[2,3,-2,4] = -48
[3] = 3
[3,-2] = -6
[3,-2,4] = -24
[-2] = -2
[-2,4] = -8
[4] = 4
```

Maximum:

```text
6
```

---

# Brute Force Complexity

## Time Complexity

```text
O(n²)
```

All subarrays checked.

---

## Space Complexity

```text
O(1)
```

No extra array used.

---

# Why Brute Force Is Inefficient

We repeatedly calculate products.

Large arrays become slow.

Need optimized state tracking.

---

# Optimization Technique

Instead of recalculating products:
store:
- maximum product till current index
- minimum product till current index

This avoids repeated work.

---

# Optimal Approach

At every index:

We calculate:

```text
currentMax
currentMin
```

because:
- positive × positive → positive
- negative × negative → positive
- positive × negative → negative

---

# State Transition

For every number:

```text
tempMax = max(
    num,
    currentMax * num,
    currentMin * num
)
```

```text
tempMin = min(
    num,
    currentMax * num,
    currentMin * num
)
```

Update:
- currentMax
- currentMin
- answer

---

# Dry Run

Input:

```text
nums = [2,3,-2,4]
```

---

## Initial State

```text
currentMax = 2
currentMin = 2
answer = 2
```

---

## Index 1 → num = 3

```text
tempMax = max(3, 2×3, 2×3)
        = 6

tempMin = min(3, 6, 6)
        = 3
```

Update:

```text
currentMax = 6
currentMin = 3
answer = 6
```

---

## Index 2 → num = -2

```text
tempMax = max(-2, 6×-2, 3×-2)
        = -2

tempMin = min(-2, -12, -6)
        = -12
```

Update:

```text
currentMax = -2
currentMin = -12
```

---

## Index 3 → num = 4

```text
tempMax = max(4, -2×4, -12×4)
        = 4
```

Final Answer:

```text
6
```

---

# Visual Intuition

## Negative Numbers Flip Product

```text
Negative × Negative = Positive
```

Therefore:
smallest negative value can become biggest positive value later.

That is why:
we track BOTH:
- max
- min

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

## Contains Zero

```text
[0,2]
```

Product resets.

---

## Single Element

```text
[-2]
```

Answer = -2

---

## All Negative Numbers

```text
[-1,-2,-3]
```

Need proper negative handling.

---

## Large Positive Product

Must update answer continuously.

---

# Technique Learned

- Dynamic Programming
- Kadane Variant
- State Tracking
- Negative Product Handling
- Maximum/Minimum State Maintenance

---

# Important DP Learning

This problem teaches:

```text
Current state can depend on both maximum and minimum previous states.
```

This is a very important DP concept.

---

# Mistakes I Made

- Initially tracked only maximum product
- Ignored effect of negative numbers
- Forgot minimum product can become maximum later

---

# Pattern Recognition

If problem contains:
- maximum product
- negative numbers
- contiguous subarray
- multiplication behavior

Think:

```text
Track BOTH max and min states
```

---

# Interview Topics Related

This problem helps build understanding of:

- Dynamic Programming
- Kadane Algorithm
- State Optimization
- Greedy Thinking
- Negative Number Handling

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

# Similar Problems

- Maximum Subarray
- House Robber
- Product of Array Except Self
- Best Time to Buy and Sell Stock

---

# Related Topics

- Dynamic Programming
- Kadane Algorithm
- Arrays
- Prefix Products
- Greedy Algorithms

---

# Real Learning From This Problem

This problem teaches one of the most important interview concepts:

```text
State tracking with changing conditions.
```

Unlike sum problems:
product problems behave differently because:
- negatives flip signs
- zeros reset products

Understanding this develops strong DP intuition.

---

# Final Java Solution

```java
class Solution {

    public int maxProduct(int[] nums) {

        int currentMax = nums[0];
        int currentMin = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int tempMax = Math.max(
                num,
                Math.max(currentMax * num, currentMin * num)
            );

            int tempMin = Math.min(
                num,
                Math.min(currentMax * num, currentMin * num)
            );

            currentMax = tempMax;
            currentMin = tempMin;

            answer = Math.max(answer, currentMax);
        }

        return answer;
    }
}
```