package structures;

import adts.IBag;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Bag<T> implements IBag<T>, Iterable<T>
{
	private static final int INITIAL_BAG_SIZE = 10;
	private T[] data;
	private int nextIndex;
	private int modCount;

	public Bag()
	{
		data = (T[])new Object[INITIAL_BAG_SIZE];
	}

	@Override
	public boolean add(T element)
	{
		//check if we have room in the bag
		if (nextIndex >= data.length)
		{
			//bag is full!
			return false;
		} else
		{
			//add the element to the bag
			data[nextIndex] = element;
			nextIndex++;
			modCount++;
			return true;
		}
	}

	@Override
	public boolean contains(T element)
	{
		for (int i = 0; i < nextIndex; i++)
		{
			if (data[i].equals(element))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(T element)
	{
		for (int i = 0; i < nextIndex; i++)
		{
			if (data[i].equals(element))
			{
				//shift elements down
				for (int j = i; j < nextIndex - 1; j++)
				{
					data[j] = data[j + 1];
				}
				data[nextIndex - 1] = null;
				nextIndex--;
				modCount++;
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int index)
	{
		//defensive programming
		if (index < 0 || index >= nextIndex)
		{
			throw new IndexOutOfBoundsException("Bad index");
		}

		return data[index];
	}

	@Override
	public int size()
	{
		return nextIndex;
	}

	@Override
	public int capacity()
	{
		return data.length;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(data);
	}

	@Override
	public Iterator<T> iterator()
	{
		return new BagIterator();
	}

	private class BagIterator implements Iterator<T>
	{
		private int currentIndex = 0;

		//save the modcount when the iterator is created
		private int savedModCount = modCount;

		@Override
		public boolean hasNext()
		{
			checkForChanges();

			return currentIndex < nextIndex;
		}

		private void checkForChanges()
		{
			if (savedModCount != modCount)
			{
				throw new ConcurrentModificationException("Cannot alter the bag while iterating");
			}
		}

		@Override
		public T next()
		{
			checkForChanges();

			T saved = data[currentIndex];

			//increment to the next index to return
			currentIndex++;

			return saved;
		}
	}
}
