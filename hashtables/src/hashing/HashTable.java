package hashing;

import java.util.Arrays;

public class HashTable<T>
{
    private static final int INIT_TABLE_CAPACITY = 5;
    private static final double LOAD_FACTOR = .5;

    private TableElement[] table;
    private int size;
    private int modCount;

    public HashTable()
    {
        //this workaround is necessary and works due to "type erasure"
        table = new TableElement[INIT_TABLE_CAPACITY];
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
        int index = getIndex(element);

        //double check that a collision has not occurred
        while (table[index] != null)
        {
            System.out.println("Collision!");
            index = (index + 1) % table.length;
        }

        table[index] = new TableElement(element);
        size++;
        modCount++;
        return true;
    }

    private int getIndex(T element)
    {
        int code = element.hashCode();
        code = Math.abs(code); //make sure code is positive!
        return code % table.length;
    }

    private void resize()
    {
        TableElement[] oldTable = table;
        table = new TableElement[oldTable.length * 2];

        //hash elements from the old table to the new table (don't just copy them!)
        size = 0;
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {
                add((T)oldTable[i].data);
            }
        }
    }

    public boolean contains(T element)
    {
        //find the position where the element should be
        int code = element.hashCode();
        code = Math.abs(code);
        int index = code % table.length;

        while (table[index] != null)
        {
            //if we found the element in the table and it hasn't been
            //previously delete (aka is active)
            if (table[index].data.equals(element) && table[index].active)
            {
                return true;
            }
            index = (index + 1) % table.length;
        }

        return false;
    }

    public boolean remove(T element)
    {
        int code = element.hashCode();
        code = Math.abs(code);
        int index = code % table.length;

        return false;
    }

    public String toString()
    {
        return Arrays.toString(table);
    }

    private static class TableElement
    {
        private Object data;
        private boolean active;

        public TableElement(Object data)
        {
            this.data = data;
            active = true;
        }

        public String toString()
        {
            return data.toString();
        }
    }
}










