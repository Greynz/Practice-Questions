# Practice-Questions



## 1.) Is Symmetric Binary Tree
https://leetcode.com/problems/symmetric-tree/

Solved recursively and iteratively. Recursive was just traversing the tree with two pointers going in opposite directions. If they didn't match up at any point, return false.
My iterative approach was to traverse the tree with two Queue's, one from left to middle, and the other from right to middle.

## 2.) Rotated Binary Search 
https://leetcode.com/problems/search-in-rotated-sorted-array/

Find the pivot via a modified binary search, determine if the target is to the left or right of the pivot, and do a binary search on that half of the array.

## 3.) Search Insert Position
https://leetcode.com/problems/search-insert-position/

Basically just a binary search.

## 4.) Simplify Unix Path
https://leetcode.com/problems/simplify-path/

Split the input string on "/" and add elements to a stack. If it's "." ignore it, if it's ".." pop the top element if it exists. Use a StringBuilder with removeLast() and voila.
Originally I had allowed .. characters to exist in the result if there were no directories to pop (ex: /../a/../.. would simplify to /../..) as it is a valid command, but the question wanted them removed entirely.

## 5.) Sort Colors
https://leetcode.com/submissions/detail/89356240/

Move red (represented by 0's) to the left and blue (2's) to the right. Ones should be left over in the middle. After I identified a 0 or 2, I would go to the beginning of the red index, 
and scan to the right until I found a non-red color. If we were still in range then we swap. Same thing for blue. Continue until we've reached the blue index.

## 6.) Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/

This algorithm is too slow for leetcode, but it does work. I may revisit this problem later with a different approach.
First I remove any characters in s that do not appear in t, and construct a third string d which is a unique sequence of characters representing the character index. the 0th index is represented by ascii
'!' and so on. I then recursively remove elements from d one at a time to get every combination of d, stopping when my length is less than t or if I have already traversed the sequence of characters
saved in a hashSet. If the length of d is == length of t, I reconstruct s from d by getting the indexes, and add it to a hashmap.