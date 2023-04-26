package lists;

public class LinkedList
{
    private Node head;
    private int size;

    public LinkedList()
    {

    }

    public void add(int element)
    {
        //what if the list is empty?
        if (head == null)
        {
            head = new Node(element, null);
        }
        else
        {
            //iterate through the list till we find the last element
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }

            //add our new node
            current.next = new Node(element, null);
        }
    }

    public boolean contains(int search)
    {
        Node current = head;
        while (current != null)
        {
            if (current.data == search)
            {
                return true;
            }

            //move to next node
            current = current.next;
        }
        return false;
    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
