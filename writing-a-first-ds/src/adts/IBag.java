package adts;

public interface IBag<T>
{
	boolean add(T element);
	boolean remove(T element);
	T get(int index);
	boolean contains(T element);
	int size();
	int capacity();
}
