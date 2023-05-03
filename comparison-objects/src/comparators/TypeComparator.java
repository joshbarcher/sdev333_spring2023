package comparators;

import coffee.CupOfCoffee;

import java.util.Comparator;

public class TypeComparator implements Comparator<CupOfCoffee>
{
    @Override
    public int compare(CupOfCoffee first, CupOfCoffee second)
    {
        return first.getType().compareTo(second.getType());
    }
}
