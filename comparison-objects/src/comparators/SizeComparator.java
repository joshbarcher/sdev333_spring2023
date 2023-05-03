package comparators;

import coffee.CupOfCoffee;

import java.util.Comparator;

public class SizeComparator implements Comparator<CupOfCoffee>
{
    @Override
    public int compare(CupOfCoffee first, CupOfCoffee second)
    {
        return first.getSizeOunces() - second.getSizeOunces();
    }
}
