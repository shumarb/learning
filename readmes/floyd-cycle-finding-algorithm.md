# Floyd's Cycle Finding Algorithm

## Overview
Floyd's Cycle Finding Algorithm is used to find a `cycle` within a linked list. A `cycle` is a path from one element to itself. This algorithm operates in `O(N)` time and uses `O(1)` extra space.

## Algorithm
1. Ensure that the linked list is not null.
2. Define two pointers: `slow`, and `fast`. Throughout this algorithm, `fast` moves at double the speed of `slow`.
3. Set `slow` and `fast` to point to the first element of the linked list.
4. At the start of iteration, check that `fast` is not null.
5. Next, check `fast` has a `next` element. If it does not, then `fast` is at the `tail` of the Linked List.
6. Set `slow` to be its next element, and `fast` to be two elements after its current element.
7. Check that `slow` and `fast` are pointing to the same element. If yes, a cycle exists.
8. The cycle check ends when `fast` is `null`, meaning all elements of the linked list have been traversed.

## Implementation
This algorithm was used to solve the following:

| Question                                                                           | Solution                                                                             | Runtime | Performance |
|------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|---------|-------------|
| [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)  | [Java](https://github.com/shumarb/leetcode/blob/main/easy/java/LinkedListCycle.java) | 0ms     | 100%        |
