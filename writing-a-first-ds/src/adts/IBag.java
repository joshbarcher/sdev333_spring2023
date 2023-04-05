package adts;

public interface IBag
{
	boolean add(Object element);
	boolean remove(Object element);
	Object get(int index);
	boolean contains(Object element);
	int size();
	int capacity();
}
