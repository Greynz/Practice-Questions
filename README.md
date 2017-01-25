# Practice-Questions

## * Is Symmetric Binary Tree
https://leetcode.com/problems/symmetric-tree/

Solved recursively and iteratively. Recursive was just traversing the tree with two pointers going in opposite directions. If they didn't match up at any point, return false.
My iterative approach was to traverse the tree with two Queue's, one from left to middle, and the other from right to middle.

## * Rotated Binary Search 
https://leetcode.com/problems/search-in-rotated-sorted-array/

Find the pivot via a modified binary search, determine if the target is to the left or right of the pivot, and do a binary search on that half of the array.

## * Can Complete Circuit Gas Station
https://leetcode.com/problems/gas-station/

At most we will be doing 2 loops around the track, so this is O(n). We start making our way around, if we don't have enough to make it to the next spot in the track, empty the tank and 
set the start to the next position. We continue this until we have made one complete circuit or we have made two circuits. Return the start index if we have made one circuit, else -1.

## * Search Insert Position
https://leetcode.com/problems/search-insert-position/

Basically just a binary search.

## * Simplify Unix Path
https://leetcode.com/problems/simplify-path/

Split the input string on "/" and add elements to a stack. If it's "." ignore it, if it's ".." pop the top element if it exists. Use a StringBuilder with removeLast() and voila.
Originally I had allowed .. characters to exist in the result if there were no directories to pop (ex: /../a/../.. would simplify to /../..) as it is a valid command, but the question wanted them removed entirely.

## * Sort Colors
https://leetcode.com/submissions/detail/89356240/

Move red (represented by 0's) to the left and blue (2's) to the right. Ones should be left over in the middle. After I identified a 0 or 2, I would go to the beginning of the red index, 
and scan to the right until I found a non-red color. If we were still in range then we swap. Same thing for blue. Continue until we've reached the blue index.

## * Distinct Subsequences
https://leetcode.com/problems/distinct-subsequences/

This algorithm is too slow for leetcode, but it does work. I may revisit this problem later with a different approach.
First I remove any characters in s that do not appear in t, and construct a third string d which is a unique sequence of characters representing the character index. the 0th index is represented by ascii
'!' and so on. I then recursively remove elements from d one at a time to get every combination of d, stopping when my length is less than t or if I have already traversed the sequence of characters
saved in a hashSet. If the length of d is == length of t, I reconstruct s from d by getting the indexes, and add it to a hashmap.

## * Sum Root to Leaf Nodes
https://leetcode.com/problems/sum-root-to-leaf-numbers/

This one ended up being quite simple. It's just a slightly modified recursive traversal algorithm.

## * Minimum Moves to Equal Array Elements
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

I ended up implementing this and then redoing it completely with a better approach. Originally I just followed the prompt and added +1 to all but one of our max elements until the whole array was
equal, and this worked fine. However we needed to recalculate max every time through my while loop, so it was quite costly. Then it dawned on me that adding 1 to all elements but one is
the same as subtracting from only one element. Rather than go through a loop and calculate that out, we can just figure it out by the difference between the min element and the current one.

## * Is Subsequences
https://leetcode.com/problems/is-subsequence/

The initial question I found too easy (it was labelled Medium but I think it should be Easy), but was a simple loop through the large string while looking for a character from the subsequence string. After we find the first character, we continue through
the loop checking against the second character, and so on. If we make it all the way through the subsequence, return true. For the follow up (what if we want to check 1billion+?) I calculate all subsequences and put them into a
hashset. Then we just loop through each string and do return hs.contains(string);

## * Contains Duplicate
https://leetcode.com/problems/contains-duplicate/

This question was essentially 'Do you know what a Hash-set is?'

## * Number of Boomerangs
https://leetcode.com/submissions/detail/90321088/

The prompt confused me a bit at first, but it wasn't so bad. Basically we just count the number of distances and add them to a hashmap. After we get through a pass,
find the number of combinations with distances of the same length (x*(x-1)).

## * Non-Recursive Inorder Traversal

Create a stack and point at the root of our tree. While we aren't pointing at something null, ad it to our stack and then move to the left node. After we hit something null, pop our stack, add it to our return list, and move
our pointer to the right child. Repeat the whole process until the right child is also null.
