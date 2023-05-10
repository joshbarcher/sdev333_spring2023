package driver;

import trees.SearchTree;

public class Main
{
    public static void main(String[] args)
    {
        SearchTree<Integer> numberTree = new SearchTree<>();
        int[] numbers = {7, 1, 69, 0, 3, 40, 2, 5, 42, 14, 31, 6, 10, 24, 3, 9, 55};

        for (int i = 0; i < numbers.length; i++)
        {
            boolean wasItAdded = numberTree.add(numbers[i]);
            System.out.println(numbers[i] + ": " + wasItAdded);
        }
        System.out.println();

        System.out.println("Size: " + numberTree.size());
        System.out.println();
        System.out.println(numberTree);

        //add a duplicate!
        System.out.println(6 + ": " + numberTree.add(40));

        System.out.println(numberTree.contains(2));
        System.out.println(numberTree.contains(42));

        System.out.println(numberTree.remove(7));
        System.out.println(numberTree.remove(1));

        System.out.println("Size: " + numberTree.size());
        System.out.println();
        System.out.println(numberTree);
    }
}