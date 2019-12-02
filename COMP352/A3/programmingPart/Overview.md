# SmartAR 
SmartAR Data Structure to manage car license plates for GARO

## General Information & Requirements:
+ Each registered car has its own unique license plate.
+ A license plate can be of length 6 - 12 alphanumeric characters.
+ The number of plates is varied (1000, and up to millions).
+ Need to keep track of the history in which a new license plate is added to the structure.
+ Even if a car is removed. It must still be in the record as "removed" history.
+ Only entries in a historical record of a key NEED to be kept in chronological order
## Detail Requirements for the Data Structure:
+ key: length 6 - 12 alphanumeric characters.
+ Able to retrieve the key of SmartAR.
+ Able to access an element by its key.
+ An element in the structure can access the next element or the last element (if exists)
+ Size maybe constant, and/or shrink dynamically. => Need to expand as requested.
+ **Adapts** to the required size of input to balance memory and runtime efficiency.
	- If contains a small number of entries, => use less memory but slower sorting algorithm.
	- If the number of entries is large => need faster sorting algorithm.
+ **Ideally:**
	- Operations applied to a single element: between *O(1)* and *O(log n)*. but never worse than *O(n)*
	- Operations applied to a complete data structure: **not exceed O(n^2).**

## In-depth Requirements:
+ Accepts the size (total number of n car registrations) as a parameter
+ Implement an appropriate ADTs to perform tasks efficiently.
+ **Methods:**
	- setThrehold(Threshold): 
	If the size is larger than or equal to threhold value
	=> use data types such as a Tree, a Hash Table, an AVL tree, or a Binary Tree
	If the size is smaller than threhold value
	=> use Sequence.
	    + set at the beginning by user
	    + user does not give anything. Set by default
	    + Perform a bunch of operations. Then user requests to set another Threhold => need to change the current Data type
	- setKeyLength(Length)
	- generate(n): randomly generates a sequence containing n new non-existing keys.
	- allKeys(): Return all kets as a sorted sequence (lexicographic order)
	- add(key, value): add an entry for given key and value
	    + Add successfully (slot is empty)
	    + Add but see that the plate was registered (the old car wasn't removed)
	    + Add successfully (slot was not empty, but the old car was removed).
	- remove(key): remove the entry for the given key.
	    + Still keeping the record of that entry. Not completely removed.
	- getValue(key): return the values of the given key
	- nextKey(key):
	- prevKey(key): return the entries in historical record. Not the whole data.
	- previousCars(key): returns a sequence (sorted in reverse chronological order) of previous cars registered with the given key (license plate). Basically, the history of this license plate.

## Test cases:
+ Benchmark files along with the program (without value)
+ Test with every functionality.

## Plan:
**File Structure**
+ Standard Structure Interface
+ SmartAR class
+ ArrayList -- sequence class
+ Hash Table class

### Design Sequence:
+ import array list
+ cannot sort by radix-sort (waste of memory)
=> Sort by merge sort

### Design Higher-Input algorithm:
+ Hash map





