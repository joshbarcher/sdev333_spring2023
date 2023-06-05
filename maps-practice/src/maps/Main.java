package maps;

import java.util.Map;
import java.util.TreeMap;

public class Main
{
    public static void main(String[] args)
    {
        Map<String, Double> movieRatings = new TreeMap<>();

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
    }
}