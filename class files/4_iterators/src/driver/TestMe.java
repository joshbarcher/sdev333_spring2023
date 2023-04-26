package driver;

import colors.RgbColor;

import java.util.Iterator;

public class TestMe
{
    public static void main(String[] args)
    {
        RgbColor purple = new RgbColor(255, 0, 155);
        System.out.println(purple);

        for (int component : purple)
        {
            System.out.println(component);
        }
        System.out.println();

        //"manually" using an iterator
        Iterator<Integer> components = purple.iterator();
        while (components.hasNext())
        {
            int component = components.next();
            System.out.println(component);
        }
    }
}
