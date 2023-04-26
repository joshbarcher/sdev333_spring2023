package driver;

import coffee.CupOfCoffee;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        CupOfCoffee[] cups = {
            new CupOfCoffee("dark roast", 16, 12.99, false),
            new CupOfCoffee("medium roast", 32, 7.99, true),
            new CupOfCoffee("flat white", 24, 14.99, true),
            new CupOfCoffee("dark roast", 64, 21.99, false)
        };
        Arrays.sort(cups);
        for (int i = 0; i < cups.length; i++)
        {
            System.out.println(cups[i]);
        }
    }
}