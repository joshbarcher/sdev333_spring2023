package driver;

import structures.Bag;

public class Main
{
    public static void main(String[] args)
    {
        Bag bagOfColors = new Bag();

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
    }
}