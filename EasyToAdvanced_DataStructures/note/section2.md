#  Static array

## def:
+ a **fixed** length container containing n elements **indexable** 
+ Random accessible.

| Operation  |Static|Dynamic|
|------------|------|-------|
| Access     | O(1) | O(1)  |
| Search     | O(n) | O(n)  |
| Insertion  | N/A  | O(n)  |
| Appending  | N/A  | O(n)  |
| Deletion   | N/A  | O(n)  |

# Dynamic array
+ the array can grow and shrink in size.
+ To implement dynamic array: Can use static array to implement.
	- step 1: Add element to static array.
	- step 2: Double size of the container
	- step 3: Copy all the elements in the old array to the new one.
	- step 4: add the requested element.

# Implementation:

