package sets;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        //this is based on binary search trees or hash tables
        Set<Character> setOfChars = new HashSet<>(); //new TreeSet<>();
        Set<Character> otherSet = new HashSet<>();
        //List<Character> setOfChars = new ArrayList<>();
        char[] letters = {'z', 'u', 'd', 'a', 'c', 'a', 'e', 'u', 'f', 'l'};
        char[] otherLetters = {'a', 'c', 'a', 'e', 'u', 'b', 'y'};

        //add all elements to the set
        addToSet(letters, setOfChars);
        addToSet(otherLetters, otherSet);

        //print out the set
        System.out.println(setOfChars);
        System.out.println(otherSet);

        //this won't work because there are no indices
        /*for (int i = 0; i < setOfChars.size(); i++)
        {
            System.out.println(setOfChars.get(i));
        }*/

        for (char letter : setOfChars)
        {
            System.out.println(letter);
        }
    }

    private static void addToSet(char[] setInputs, Set<Character> set)
    {
        for (char letter : setInputs)
        {
            set.add(letter);
        }
    }
}