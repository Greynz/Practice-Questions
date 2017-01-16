# Practice-Questions

## 1.) Rotated Binary Search 
https://leetcode.com/problems/search-in-rotated-sorted-array/

Find the pivot via a modified binary search, determine if the target is to the left or right of the pivot, and do a binary search on that half of the array.

## 2.) Simplify Unix Path
https://leetcode.com/problems/simplify-path/

Split the input string on "/" and add elements to a stack. If it's "." ignore it, if it's ".." pop the top element if it exists. Use a StringBuilder with removeLast() and voila.
Originally I had allowed .. characters to exist in the result if there were no directories to pop (ex: /../a/../.. would simplify to /../..) as it is a valid command, but the question wanted them removed entirely.

## 3.) Sort Colors
https://leetcode.com/submissions/detail/89356240/

Move red (represented by 0's) to the left and blue (2's) to the right. Ones should be left over in the middle. After I identified a 0 or 2, I would go to the beginning of the red index, 
and scan to the right until I found a non-red color. If we were still in range then we swap. Same thing for blue. Continue until we've reached the blue index.
