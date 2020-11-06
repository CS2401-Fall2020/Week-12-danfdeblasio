# Week 12

In this week's lab we will be exploring more binary search trees. 
This week we will be doing this by modifying the base binary search on integers to include methods that will
find or remove the min or max numbers that are either specifically odd or even (that will be 8 methods).  

I have provided you with the framework for the BST Node Class, you will need to fill in the 12 methods described above, 
as well as the standard `insert`, `search`, and `remove` methods (some of which will be called within your new methods).
These base methods will should be based on the methods we developed in class, the code for which can be found on github in https://github.com/CS2401-Fall2020/October26-inClass/.

## Your Tasks

**All of the methods below are recursive, do not change the method signitures**

Fill in the following methods:
* `void insert(int)` -- Inserts a given integer into a given binary search tree.
* `void remove(int)` -- Removes a given integer from a tree (assuming it exists).  
* `void removeMinOdd()` -- Removes the node that is labeled with the minimum odd number contained in the tree. If no odd numbers are in the tree, do nothing. 
* `void removeMinEven()` -- Removes the node that is labeled with the minimum even number contained in the tree. If no even numbers are in the tree, do nothing. 
* `void removeMaxOdd()` -- Removes the node that is labeled with the maximum odd number contained in the tree. If no odd numbers are in the tree, do nothing. 
* `void removeMaxEven()` -- Removes the node that is labeled with the maximum even number contained in the tree. If no even numbers are in the tree, do nothing. 

You will also fill in the following helper methods (these will be used in the methods above). 
* `BSTNode findMin()` -- Searches the tree to find the (pointer to) the node with the minimum value in the subtree. 
* `BSTNode findMinOdd()` -- Searches the tree to find the (pointer to) the node with the minimum odd value in the subtree. If no odd numbers are in the tree, return `null`. 
* `BSTNode findMinEven()` -- Searches the tree to find the (pointer to) the node with the minimum even value in the subtree. If no even numbers are in the tree, return `null`.
* `BSTNode findMaxOdd()` -- Searches the tree to find the (pointer to) the node with the maximum odd value in the subtree. If no odd numbers are in the tree, return `null`. 
* `BSTNode findMaxEven()` -- Searches the tree to find the (pointer to) the node with the maximum even value in the subtree. If no even numbers are in the tree, return `null`. 
* `int countOdd()` -- Counts the number of nodes in the (sub)tree that are labeled with an odd number. 
* `int countEven()` -- Counts the number of nodes in the (sub)tree that are labeled with an even number. 

### Testing
You will need to compile a test file (`tester.java`) to demonstrate that your tree class works properly. 

## Grading
**125 points total**
* `void insert(int)` -- 10 pts
* `void remove(int)`  -- 10 pts
* `void removeMinOdd()`  -- 10 pts
* `void removeMinEven()`  -- 10 pts 
* `void removeMaxOdd()`  -- 10 pts 
* `void removeMaxEven()`  -- 10 pts
* `BSTNode findMin()`  -- 5 pts
* `BSTNode findMinOdd()`  -- 10 pts
* `BSTNode findMinEven()`  -- 10 pts
* `BSTNode findMaxOdd()`  -- 10 pts 
* `BSTNode findMaxEven()`  -- 10 pts
* `int countOdd()`  -- 5 pts 
* `int countEven()` -- 5 pts
* Tests -- 10 pts
