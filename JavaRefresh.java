import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;

/**
 *
 * @author Andrew King / 811418557 / ack21572 
 * Assignment 1: Learning Java 
 * Artificial Intelligence - CSCI 6550
 * 
 */
public class JavaRefresh {

    /**
     * my_intersection returns the intersection of the two lists. It takes two ArrayList<Character> as arguments. 
     * If there are repeating characters in the passed in lists, my_union will only return it in the list once. 
     */
    public ArrayList my_intersection(ArrayList<Character> list1, ArrayList<Character> list2) {
        ArrayList<Character> intersection = new ArrayList<>();
        //iterate over list one
        for (Character chara : list1) {
            //if it is in list2 and isn't already in our intersection ArrayList add it to the intersection ArrayList
            if (list2.contains(chara) && !intersection.contains(chara)) {
                intersection.add(chara);
            }
        }
        //return our intersection ArrayList
        return intersection;
    }

    /**
     * my_union returns the union of the two lists. It takes two ArrayList<Character> as arguments. 
     * If there are repeating characters in the passed in lists, my_union will only return it in the list once.
     */
    public ArrayList my_union(ArrayList<Character> list1, ArrayList<Character> list2) {
        ArrayList<Character> union = new ArrayList<>();
        //iterate over the list1
        for (Character chara : list1) {
            //if the union arraylist doesn't contain chara: add it
            if (!union.contains(chara)) {
                union.add(chara);
            }
        }
        //iterate over list2
        for (Character chara : list2) {
            //if the union arraylist doesn't contain chara: add it
            if (!union.contains(chara)) {
                union.add(chara);
            }
        }
        //return our union ArrayList
        return union;
    }

    /**
     * addvec returns the sum of all values in a list. It takes an ArrayList<Integer> as an argument. 
     * If the list is empty addvec will return 0.
     */
    public int addvec(ArrayList<Integer> list) {
        //variable to keep track of the sum
        int mySum = 0;
        //iterate over the list and add each number to mySum
        for (int i : list) {
            mySum += i;
        }
        return mySum;
    }

    /**
     * vecmul returns an ArrayList of the coordinate-wise products of two lists. 
     * It takes two ArrayList<Integer> as arguments. 
     * If one list is longer than the other, the result is as if the shorter list were padded with ones.
     */
    public ArrayList vecmul(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> vecProduct = new ArrayList<>();
        //set longSize to the size of the longest list
        int longSize;
        if (list1.size() < list2.size()) {
            longSize = list2.size();
        } else {
            longSize = list1.size();
        }
        //run for the length of the longest list
        for (int i = 0; i < longSize; i++) {
            //init our two product values
            int firstP = 1;
            int secondP = 1;
            //set their values to their corresponding list value only if the value exists (otherwise it will default to 1)
            if (i < list1.size()) {
                firstP = list1.get(i);
            }
            if (i < list2.size()) {
                secondP = list2.get(i);
            }
            //add the product of these numbers to our new arraylist
            vecProduct.add(firstP * secondP);
        }
        //return our arraylist
        return vecProduct;
    }

    /**
     * innprod first multiplies two lists coordinate-wise and then returns an int of the sum of their coordinate-wise products. 
     * It takes two ArrayList<Integer> as arguments. 
     * If one list is longer than the other, the products are as if the shorter list were padded with ones.
     */
    public int innprod(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        //Create a new ArrayList for the coordinate-wise products of the two lists
        ArrayList prod = vecmul(list1, list2);
        //add the values in the new ArrayList together
        int sum = addvec(prod);
        return sum;
    }

    /**
     * occurrences returns a list that indicates how many times each element appears. 
     * It takes an ArrayList as an argument. 
     * The returned list will be sorted from most common to least common. 
     */
    public ArrayList occurrences(ArrayList list) {
        //New arraylist so our changes do not affect the passed in list
        ArrayList occur = new ArrayList();
        occur.addAll(list);
        //New arraylist for our sorted and occurence enumerated values
        ArrayList occArraySorted = new ArrayList();
        //while there are still items in the occur ArrayList
        while (!occur.isEmpty()) {
            //set the index of the element we are dealing with
            int index = 0;
            //int for keeping track of the max number of occurences
            int max = 0;
            //loop through occur and find the item with the highest number of occurences
            for (int i = 0; i < occur.size(); i++) {
                if (Collections.frequency(occur, occur.get(i)) > max) {
                    max = Collections.frequency(occur, occur.get(i));
                    index = i;
                }
            }
            //create a sublist
            ArrayList sublist = new ArrayList();
            //add the max item to the sublist
            sublist.add(occur.get(index));
            //add the frequency number to the sublist
            sublist.add(max);
            //add the sublist to the sorted arraylist
            occArraySorted.add(sublist);
            //remove the item with the most number of occurences from occur so that next time it will get the next highest
            occur.removeAll(Collections.singleton(occur.get(index)));
        }
        return occArraySorted;
    }

    /**
     * my_trianglenos returns a boolean value that is true if a list of given integers contains only triangle numbers (otherwise it returns false). 
     * It takes an ArrayList<Integer> as an argument. 
     * If the list is empty or contains a negative number it will return false (since it is not a list of only triangle numbers).
     */
    public boolean my_trianglenos(ArrayList<Integer> list) {

        //if the list is empty it is not a list containing only triangle numbers so return false
        if (list.isEmpty()) {
            return false;
        }
        //check every number in the list
        for (int i = 0; i < list.size(); i++) {
            double check = (list.get(i) * 8) + 1;
            //take the square root and cast it as an int
            int cksqt = (int) sqrt(check);
            //because we casted as int, it will only equal our original number (check) if it was an int to begin with (a perfect square)
            //if it is a perfect square move on and check the next number 
            if (cksqt * cksqt != check) {
                return false;
            }
        }
        return true;
    }

    /**
     * number_embed returns an int of the number of embedded lists in a passed in list. 
     * It takes an ArrayList as an argument. 
     * It makes use of recursion and therefore an external variable int numemb.
     */
    private int numemb = 0;

    public int number_embed(ArrayList list) {
        for (Object item : list) {
            //If we have an arraylist increase our counter
            if (item.getClass().equals(ArrayList.class)) {
                numemb++;
                //we then need to call it recursively to check the list within the list for a list
                number_embed((ArrayList) item);
            }
        }
        return numemb;
    }

    /**
     * powerset returns the list of all subsets of a list of characters. It takes an ArrayList<Character> as an argument. 
     * Repeated characters will not generate new permutations as they are effectively ignored. 
     * If an empty list is passed in it will return only the empty set.
     */
    public ArrayList powerset(ArrayList<Character> list) {
        //Use java8 streams to collect only the distinct elements of the list
        List<Character> noDupList = list.stream().distinct().collect(Collectors.toList());
        //create our list for storing powersets
        ArrayList powerSetList = new ArrayList(new ArrayList());
        //add the empty set
        powerSetList.add(new ArrayList());
        //Take the current state of powerSetList, add the results when we add the next letter to every item in powerSetList
        //The new letters are added by themselves because of our iteration over the empty set
        for (char c : noDupList) {
            //go through the current state of powerSetList (which on first run is only the empty set)
            for (Object set : new ArrayList(powerSetList)) {
                //it will add the items of set (which on first run is empty) to sub
                ArrayList sub = new ArrayList((Collection) set);
                //add our letter from list to sub
                sub.add(c);
                //add sub to our powerset
                powerSetList.add(sub);
            }
        }
        //sort our powerset list from smallest to largest
        Collections.sort(powerSetList, new Comparator<ArrayList>() {
            public int compare(ArrayList ar1, ArrayList ar2) {
                return ar1.size() - ar2.size();
            }
        });
        return powerSetList;
    }

    /**
     * Sample driver of JavaRefresh methods
     */
    public JavaRefresh() {
        //Question 1
        System.out.println("Question 1");
        //Two List Setup
        ArrayList<Character> firstList = new ArrayList<>();
        firstList.add('e');
        firstList.add('d');
        firstList.add('d');
        firstList.add('f');
        firstList.add('g');
        firstList.add('g');
        ArrayList<Character> secondList = new ArrayList<>();
        secondList.add('d');
        secondList.add('d');
        secondList.add('g');
        secondList.add('j');
        //my_intersection test
        ArrayList my_intersection = my_intersection(firstList, secondList);
        System.out.println("MY_INTERSECTION TEST");
        System.out.print("First List: ");
        System.out.println(firstList);
        System.out.print("Second List: ");
        System.out.println(secondList);
        System.out.print("Intersection: ");
        System.out.println(my_intersection);
        //my_union test
        ArrayList my_union = my_union(firstList, secondList);
        System.out.println("MY_UNION TEST");
        System.out.print("First List: ");
        System.out.println(firstList);
        System.out.print("Second List: ");
        System.out.println(secondList);
        System.out.print("Union: ");
        System.out.println(my_union);

        //Question 2
        System.out.println('\n' + "Question 2");
        //Two list setup
        ArrayList<Integer> firstIntList = new ArrayList<>();
        firstIntList.add(2);
        firstIntList.add(3);
        firstIntList.add(4);
        firstIntList.add(5);
        ArrayList<Integer> secondIntList = new ArrayList<>();
        secondIntList.add(1);
        secondIntList.add(4);
        secondIntList.add(5);
        secondIntList.add(2);
        secondIntList.add(14);
        //addvec test
        System.out.println("ADDVEC TEST");
        System.out.print("List: ");
        System.out.println(firstIntList);
        System.out.print("Sum: ");
        System.out.println(addvec(firstIntList));
        //vecmul test
        System.out.println("VECMUL TEST");
        System.out.print("First List: ");
        System.out.println(firstIntList);
        System.out.print("Second List: ");
        System.out.println(secondIntList);
        System.out.print("List of Products: ");
        System.out.println(vecmul(firstIntList, secondIntList));
        //innprod test
        System.out.println("INNPROD TEST");
        System.out.print("First List: ");
        System.out.println(firstIntList);
        System.out.print("Second List: ");
        System.out.println(secondIntList);
        System.out.print("Sum of the Products: ");
        System.out.println(innprod(firstIntList, secondIntList));

        //Question 3
        System.out.println('\n' + "Question 3");
        //List setup
        ArrayList occList = new ArrayList();
        occList.add('a');
        occList.add('a');
        ArrayList occListInner1 = new ArrayList();
        occListInner1.add('b');
        occList.add(occListInner1);
        occList.add('a');
        occList.add('c');
        occList.add('c');
        occList.add('d');
        ArrayList occListInner2 = new ArrayList();
        occListInner2.add('c');
        ArrayList occListInner3 = new ArrayList();
        occListInner3.add('d');
        occListInner2.add(occListInner3);
        occList.add(occListInner2);
        occList.add(occListInner1);
        occList.add('b');
        occList.add('d');
        //occurences test
        System.out.println("OCCURANCES TEST");
        System.out.print("List: ");
        System.out.println(occList);
        System.out.print("Occurances: ");
        System.out.println(occurrences(occList));

        //Question 4
        System.out.println('\n' + "Question 4");
        //list setup
        ArrayList<Integer> triList = new ArrayList<>();
        //trinagle numbers
        triList.add(1);
        triList.add(3);
        triList.add(6);
        triList.add(10);
        triList.add(15);
        triList.add(21);
        ArrayList<Integer> notTryList = new ArrayList<>();
        //Triangle Numbers
        notTryList.add(1);
        notTryList.add(2);
        //not a triangle number
        notTryList.add(3);
        //my_trianglenos test
        System.out.println("MY_TRIANGLENOS TEST");
        //Trinagle List
        System.out.println("List: " + triList);
        System.out.print("Result: ");
        System.out.println(my_trianglenos(triList));
        //Not a Trinagle List
        System.out.println("List: " + notTryList);
        System.out.print("Result: ");
        System.out.println(my_trianglenos(notTryList));

        //Question 5
        System.out.println('\n' + "Question 5");
        //list setup 
        ArrayList neList = new ArrayList();
        neList.add(1);
        ArrayList inceptionList1 = new ArrayList();
        inceptionList1.add(2);
        neList.add(inceptionList1);
        neList.add(3);
        ArrayList inceptionList2 = new ArrayList();
        inceptionList2.add(4);
        ArrayList inceptionList3 = new ArrayList();
        inceptionList3.add(5);
        inceptionList3.add(6);
        inceptionList2.add(inceptionList3);
        neList.add(inceptionList2);
        //number_embed test
        System.out.println("NUMBER_EMBED TEST");
        System.out.println("List: " + neList);
        System.out.print("Result: ");
        System.out.println(number_embed(neList));

        //Question 6
        System.out.println('\n' + "Question 6");
        //list setup
        ArrayList<Character> powerList = new ArrayList<>();
        powerList.add('a');
        powerList.add('b');
        powerList.add('b');
        powerList.add('c');
        //powerset Test
        System.out.println("POWERSET TEST");
        System.out.println("List: " + powerList);
        System.out.print("Result: ");
        System.out.println(powerset(powerList));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaRefresh javaRefresh = new JavaRefresh();
    }

}
