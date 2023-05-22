package hashing;

import java.util.Arrays;

public class HashTable<T>
{
    private static final int INIT_TABLE_CAPACITY = 5;
    private static final double LOAD_FACTOR = .5;

    private T[] table;
    private int size;
    private int modCount;

    public HashTable()
    {
        //this workaround is necessary and works due to "type erasure"
        table = (T[])new Object[INIT_TABLE_CAPACITY];
    }

    public boolean add(T element)
    {
        //will this new element exceed our load factor?
        if ((size + 1.0) / table.length > LOAD_FACTOR)
        {
            resize();
        }

        //hash tables don't support duplicates!
        if (contains(element))
        {
            return false;
        }

        //use the hash-code to find a position (quickly) in the table
        int code = element.hashCode();
        code = Math.abs(code); //make sure code is positive!
        int index = code % table.length;

        //double check that a collision has not occurred
        while (table[index] != null)
        {
            System.out.println("Collision!");
            index = (index + 1) % table.length;
        }

        table[index] = element;
        size++;
        modCount++;
        return true;
    }

    private void resize()
    {
        T[] oldTable = table;
        table = (T[])new Object[oldTable.length * 2];

        //hash elements from the old table to the new table (don't just copy them!)
        size = 0;
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {
                add(oldTable[i]);
            }
        }
    }

    public boolean contains(T element)
    {
        return false;
    }

    public boolean remove(T element)
    {
        return false;
    }

    public String toString()
    {
        return Arrays.toString(table);
    }
}










