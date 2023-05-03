package adts;

public interface ITree<T extends Comparable<T>>
{
    //essential
    boolean add(T element);
    boolean contains(T element);
    int size();
    boolean isEmpty();
    void clear();
    boolean remove(T element);

    //nice-to-have
    int treeHeight();
}
