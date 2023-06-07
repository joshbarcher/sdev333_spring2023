package analytics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class BookReader
{
    public static void main(String[] args)
    {
        //try-with-resources (the file will be closed automatically)
        try (Scanner fileReader = new Scanner(new FileInputStream("files/the-great-gatsby.txt")))
        {
            //stores word frequencies
            TreeMap<String, Integer> histogram = new TreeMap<>();

            //loop over each line of the file
            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String[] words = line.split(" ");

                //loop over each word
                for (String word : words)
                {
                    //make it lowercase
                    word = word.toLowerCase();

                    //remove all special characters
                    String[] punctuations = {".", ",", "\"", ":", ";", "?", "!", "”", "“", "’", "‘",
                                             "\t"};
                    for (String punctuation : punctuations)
                    {
                        word = word.replace(punctuation, "");
                    }

                    //record the frequency of the word
                    if (histogram.containsKey(word)) //we've seen this word before
                    {
                        int frequency = histogram.get(word);
                        histogram.put(word, frequency + 1);
                    }
                    else //we've never seen this word
                    {
                        histogram.put(word, 1); //we've seen the word 1 time
                    }
                }
            }

            //print out the pairs in our histogram!
            for (String word : histogram.keySet())
            {
                int frequency = histogram.get(word);
                System.out.println(word + " shows up " + frequency + " times!");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
    }
}
