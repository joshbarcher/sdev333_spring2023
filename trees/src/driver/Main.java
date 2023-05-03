package driver;

import trees.SearchTree;

public class Main
{
    public static void main(String[] args)
    {
        SearchTree<Integer> numberTree = new SearchTree<>();
        int[] numbers = {7, 1, 69, 0, 3, 40, 2, 5};

        for (int i = 0; i < numbers.length; i++)
        {
            boolean wasItAdded = numberTree.add(numbers[i]);
            System.out.println(numbers[i] + ": " + wasItAdded);
        }

        //add a duplicate!
        System.out.println(6 + ": " + numberTree.add(40));

        System.out.println(numberTree.contains(2));
        System.out.println(numberTree.contains(42));
    }
}