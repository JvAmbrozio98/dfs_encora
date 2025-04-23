import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] input = {1, 2, 3}; // Static Input  with up to 4 elements to simulate user input
       // Try block to catch IllegalArgumentException case an array with size greater than 4 is passed to the function
        try {
            //Function getSubSets is called and its return is stored in the variable 'results'
           Set<List<Integer>> results = getSubSets(input);
           //For loop displaying the subsets
           for (List<Integer> subset : results) {
               System.out.println(subset);
           }

       } catch (IllegalArgumentException e) {
           //Error message
            System.out.println("The array size cant be bigger than 4 ");
       }



    }

    // Recursive depthFirstSearch function to explore all subset possibilities
    public static void depthFirstSearch (int[] nums, int i, List<Integer> subset, Set<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> copy = new ArrayList<>(subset);
            Collections.sort(copy);
            res.add(copy);
            return;
        }
        subset.add(nums[i]);
        depthFirstSearch(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        depthFirstSearch(nums, i + 1, subset, res);
    }

    // Main function to initialize data structures and start D
    public static Set<List<Integer>> getSubSets(int[] nums) {
        if (nums.length > 4) {
            throw new IllegalArgumentException("Input array must contain 4 elements or fewer.");
        }

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        depthFirstSearch(nums, 0, subset, res);
        return res;
    }
}
