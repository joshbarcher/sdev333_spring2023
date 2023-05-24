package driver;

import hashing.HashTable;

public class Main
{
    public static void main(String[] args)
    {
        HashTable<String> hashTable = new HashTable<>();

        String[] colors = {"chartreuse", "blue", "green",
                "purple", "teal", "white", "red", "beige",
                "orange", "gray"};

        for (String color : colors)
        {
            hashTable.add(color);
        }
        System.out.println(hashTable);

        //test contains()
        System.out.println("contains('blue'): " +
                hashTable.contains("blue"));
        System.out.println("contains('orange'): " +
                hashTable.contains("orange"));
        System.out.println("contains('yellow'): " +
                hashTable.contains("yellow"));
    }
}