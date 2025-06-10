# Boyer-Moore Majority Voting Algorithm

## Overview
The Boyer-Moore Majority Voting Algorithm is efficient technique to find the `majority` element
(element appearing more than `⌊N / 2⌋` times) in a fixed dataset of size `N`.
This algorithm operates in `O(N)` time and uses `O(1)` extra space.

## Algorithm
1. Set a candidate as `null` and `count` as 0.
2. For each element:
    1. If `count` is 0, set the current element as the new `candidate`.
    2. If the current element is equal to the `candidate`, increment `count`, else decrement `count`.
3. Check that the `candidate` at the end of the traversal is the `majority element` by confirming the number of times it appears is > `⌊N / 2⌋` times.
4. If the check at step 3 passes, return the `candidate`, else indicate no `majority element`.

## Implementation
This algorithm was used to solve the following:

| Question                                                                           | Solution                                                                               | Runtime | Performance |
|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|---------|-------------|
| [Majority Element](https://leetcode.com/problems/majority-element/description/)    | [Java](https://github.com/shumarb/leetcode/blob/main/submissions/MajorityElement.java) | 2ms     | 99.80%      |
