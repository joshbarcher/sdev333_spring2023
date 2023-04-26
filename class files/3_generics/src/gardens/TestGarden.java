package gardens;

import thing.Potato;

public class TestGarden
{
    public static void main(String[] args)
    {
        Garden<Plant> plantGarden = new Garden<>(new Plant("Shrub"));
        Garden<Plant> roseGarden = new Garden<>(new Rose("Red Rose"));

        //Garden<String> stringGarden = new Garden<String>("Uh oh");

        Potato pot = new Potato("red");
        Potato anotherPot = new Potato();
    }
}
