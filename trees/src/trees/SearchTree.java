package trees;

import adts.ITree;

public class SearchTree<T extends Comparable<T>> implements ITree<T>
{
    private Node root;
    private int size;

    @Override
    public boolean add(T element)
    {
        int savedSize = size;
        root = add(root, element);
        return savedSize != size;
    }

    private Node add(Node current, T element)
    {
        //base case
        if (current == null)
        {
            size++;
            return new Node(element);
        }

        int comparison = current.data.compareTo(element);

        if (comparison == 0)
        {
            return current;
        }
        else if (comparison < 0)
        {
            //traverse to the right
            current.right = add(current.right, element);
        }
        else
        {
            //traverse to the left
            current.left = add(current.left, element);
        }
        return current;
    }

    @Override
    public boolean contains(T element)
    {
        return contains(root, element);
    }

    private boolean contains(Node current, T element)
    {
        if (current == null)
        {
            return false;
        }

        int comparison = current.data.compareTo(element);
        if (comparison == 0)
        {
            return true;
        }
        else if (comparison < 0)
        {
            //search to the right
            return contains(current.right, element);
        }
        else
        {
            //search to the left
            return contains(current.left, element);
        }
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public boolean remove(T element)
    {
        return false;
    }

    @Override
    public int treeHeight()
    {
        return 0;
    }

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data)
        {
            this.data = data;
        }

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
