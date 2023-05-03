package driver;

import structures.Bag;

import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        Bag<String> bagOfColors = new Bag<String>();
        Bag<Integer> bagOfNums = new Bag<Integer>();

        String[] colors = {"green", "blue",
            "purple", "gray", "yellow",
            "white", "black", "brown",
            "orange", "cyan", "red"};

        for (String color : colors)
        {
            boolean added = bagOfColors.add(color);
            if (added)
            {
                System.out.println("Color added - " + color);
            }
            else
            {
                System.out.println("Color NOT added - " + color);
            }
        }

//        for (int i = 0; i < colors.length; i++)
//        {
//            bagOfColors.add(colors[i]);
//        }

        System.out.println(bagOfColors);

        bagOfColors.remove("purple");
        System.out.println(bagOfColors);
        bagOfColors.remove("yellow");
        System.out.println(bagOfColors);

        //System.out.println(bagOfColors.get(0));

        //use the bag in a regular for loop
        System.out.println("Printing in for loop");
        for (int i = 0; i < bagOfColors.size(); i++)
        {
            System.out.println(bagOfColors.get(i));
        }

        System.out.println("Printing in a for-each loop");
        for (String color : bagOfColors)
        {
            System.out.println(color);
        }

        Iterator<String> it = bagOfColors.iterator();
        while (it.hasNext())
        {
            String element = it.next();

            System.out.println(element);
        }
    }
}