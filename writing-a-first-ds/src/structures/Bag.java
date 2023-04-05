package structures;

import adts.IBag;

import java.util.Arrays;

public class Bag implements IBag
{
	private static final int INITIAL_BAG_SIZE = 10;
	private Object[] data;
	private int nextIndex;

	public Bag()
	{
		data = new Object[INITIAL_BAG_SIZE];
	}

	@Override
	public boolean add(Object element)
	{
		//check if we have room in the bag
		if (nextIndex >= data.length)
		{
			//bag is full!
			return false;
		}
		else
		{
			//add the element to the bag
			data[nextIndex] = element;
			nextIndex++;
			return true;
		}
	}

	@Override
	public boolean remove(Object element)
	{
		return false;
	}

	@Override
	public Object get(int index)
	{
		return null;
	}

	@Override
	public boolean contains(Object element)
	{
		return false;
	}

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public int capacity()
	{
		return 0;
	}

	@Override
	public String toString()
	{
		return Arrays.toString(data);
	}
}
