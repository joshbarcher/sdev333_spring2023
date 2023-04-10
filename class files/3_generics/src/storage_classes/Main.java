package storage_classes;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        GenericStorage<Integer> store1 = new GenericStorage<>(10);
        GenericStorage<String> store2 = new GenericStorage<>("hello");
        GenericStorage<Boolean> store3 = new GenericStorage<>(true);

        System.out.println(store1.getData() + 30);
        System.out.println(store2.getData().toUpperCase());
        System.out.println(store3.getData());

        /*String message = "Hello";
        Object holder = message;

        String converted = (String)holder;
        converted.toLowerCase();*/

        ArrayList<String> stringsList = new ArrayList<>();
    }
}
