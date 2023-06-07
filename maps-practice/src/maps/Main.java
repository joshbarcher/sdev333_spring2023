package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args)
    {
        Map<String, Double> movieRatings = new HashMap<>();

        //add our movie ratings
        movieRatings.put("Velocipastor", 2.5);
        movieRatings.put("Cocaine Bear", 3.0);
        movieRatings.put("Blazing Saddles", 5.0);
        movieRatings.put("Knights Tale", 3.0);
        movieRatings.put("The Starving Games", 1.0);
        //movieRatings.put("The Starving Games", 1.5);

        System.out.println(movieRatings);

        //Is Cocaine Bear in our ratings table?
        System.out.println("Cocaine bear is in the map? " +
                movieRatings.containsKey("Cocaine Bear"));
        System.out.println("Sharknado is in the map? " +
                movieRatings.containsKey("Sharknado"));

        //Did a movie get a 1.0 rating?
        System.out.println("Is there a 1.0 rating for a movie? " +
                movieRatings.containsValue(1.0));

        //loop over our movies (the keys)
        for (String title : movieRatings.keySet())
        {
            System.out.println(title);
        }

        //this doesn't work!
        /*for (int i = 0; i < movieRatings.size(); i++)
        {
            System.out.println(movieRatings.get(i));
        }*/

        //loop over our ratings (the values)
        for (double rating : movieRatings.values())
        {
            if (rating < 2.5)
            {
                System.out.println("Found a bad movie");
            }
            else
            {
                System.out.println("Found a good movie");
            }
        }

        //loop over the pairs (keys and values)
        for (String title : movieRatings.keySet())
        {
            double rating = movieRatings.get(title);
            System.out.println(title + " -> " + rating);
        }
        System.out.println();

        //loop over the pairs using Entry objects (keys and values)
        for (Map.Entry<String, Double> pair : movieRatings.entrySet())
        {
            System.out.println(pair.getKey() + " -> " + pair.getValue());
        }
    }
}