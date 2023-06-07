package dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryProgram
{
    public static void main(String[] args)
    {
        TreeMap<String, String> dict = loadDictionary();

        for (String word : dict.keySet())
        {
            System.out.println(word + " -> " + dict.get(word));
        }
    }

    private static TreeMap<String, String> loadDictionary()
    {
        try (Scanner reader = new Scanner(new FileInputStream("files/dictionary.txt")))
        {
            TreeMap<String, String> dictionary = new TreeMap<>();

            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] parts = line.split(": ", 2);

                dictionary.put(parts[0], parts[1]);
            }
            return dictionary;
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
        return null;
    }
}
