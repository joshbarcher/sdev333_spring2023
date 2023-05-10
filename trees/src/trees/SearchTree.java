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
    public boolean remove(T element)
    {
        int savedSize = size;
        root = remove(root, element);
        return savedSize != size;
    }

    private Node remove(Node current, T element)
    {
        //base case
        if (current == null)
        {
            //not found!
            System.out.println("Not found!");
            return null;
        }

        int comparison = current.data.compareTo(element);
        if (comparison < 0)
        {
            current.right = remove(current.right, element);
        }
        else if (comparison > 0)
        {
            current.left = remove(current.left, element);
        }
        else //base case - we found it!
        {
            //no children
            if (current.left == null && current.right == null)
            {
                size--;
                return null;
            }
            else if (current.right == null) //left child
            {
                size--;
                return current.left;
            }
            else if (current.left == null) //right child
            {
                size--;
                return current.right;
            }
            else //two children
            {
                Node largestInLeftTree = findMax(current.left);
                current.data = largestInLeftTree.data;
                current.left = remove(current.left, largestInLeftTree.data);
            }
        }
        return current;
    }

    public Node findMax(Node current)
    {
        //base case
        if (current.right == null)
        {
            return current;
        }

        //recursive call
        return findMax(current.right);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        root = null;
        size = 0;
    }

    @Override
    public int treeHeight()
    {
        return 0;
    }

    public String toString()
    {
        return root == null ? "null" : root.toString();
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

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder builder)
        {
            if(right!=null)
            {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, builder);
            }

            builder.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append("\n");

            if(left!=null)
            {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, builder);
            }

            return builder;
        }

        /**
         * Builds a visualization of the tree on the Java console.
         *
         * @see https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java/8948691#8948691
         * @return a diagram of the tree
         */
        @Override
        public String toString()
        {
            return toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }
}
