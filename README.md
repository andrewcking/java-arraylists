# java-arraylists
A series of Algorithms for Java ArrayList

**How to Run:**

JavaRefresh.java includes example invocations for all methods in its constructor. To see the sample output and tests, simply compile JavaRefresh.java using terminal (javac JavaRefresh.java) and run it (java JavaRefresh). Further tests can be added to the constructor if desired.

**List of Methods, Their Parameters and Return values:**

my_intersection

	Parameters: ArrayList<Character> x2
	Returns: ArrayList<Character>
	
my_union

	Parameters: ArrayList<Character> x2
	Returns: ArrayList<Character>
	
addvec 

	Parameters: ArrayList<Integer>
	Returns: int
	
vecmul

	Parameters: ArrayList<Integer> x2
	Returns: ArrayList<Integer>
	
innprod 

	Parameters: ArrayList<Integer> x2
	Returns: int
	
occurrences

	Parameters: ArrayList
	Returns: ArrayList
	
my_trianglenos 

	Parameters: ArrayList<Integer>
	Returns: boolean
	
number_embed

	Parameters: ArrayList
	Returns: int
	
powerset

	Parameters: ArrayList<Character>
	Returns: ArrayList


**Detailed Explanations:**

my_intersection returns the intersection of the two lists. It takes two ArrayList<Character> as arguments. If there are repeating characters in the passed in lists, my_union will only return it in the list once. For instance ArrayList [d,d] and [e,d,d] will return [d].


my_union returns the union of the two lists. It takes two ArrayList<Character> as arguments. If there are repeating characters in the passed in lists, my_union will only return it in the list once. For instance ArrayList [d,d] and [e,d,d] will return [d,e].


addvec returns the sum of all values in a list. It takes an ArrayList<Integer> as an argument. If the list is empty addvec will return 0.


vecmul returns an ArrayList of the coordinate-wise products of two lists. It takes two ArrayList<Integer> as arguments. If one list is longer than the other, the result is as if the shorter list were padded with ones.


innprod first multiplies two lists coordinate-wise and then returns an int of the sum of their coordinate-wise products. It takes two ArrayList<Integer> as arguments. If one list is longer than the other, the products are as if the shorter list were padded with ones.


occurrences returns a list that indicates how many times each element appears. It takes an ArrayList as an argument. The passed in list may contain lists as elements. The returned list will be sorted from most common to least common. If an empty list is passed in it will return an empty list.


my_trianglenos returns a boolean value that is true if a list of given integers contains only triangle numbers (otherwise it returns false). It takes an ArrayList<Integer> as an argument. If the list is empty or contains a negative number it will return false (since it is not a list of only triangle numbers).


number_embed returns an int of the number of embedded lists in a passed in list. It takes an ArrayList as an argument. It makes use of recursion and therefore an external variable int numemb. If an empty list is passed in it returns a 0. 


powerset returns the list of all subsets of a list of characters. It takes an ArrayList<Character> as an argument. Repeated characters will not generate new permutations as they are effectively ignored. If an empty list is passed in it will return only the empty set.

