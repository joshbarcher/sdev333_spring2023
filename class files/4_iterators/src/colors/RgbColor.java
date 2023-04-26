package colors;

import java.util.Iterator;

//iterable that returns integers
public class RgbColor implements Iterable<Integer>
{
    //components must be in range [0, 255]
    private int red, green, blue;

    public RgbColor(int red, int green, int blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

    @Override
    public String toString()
    {
        return "Color {" + red + ", " + green +", " + blue + '}';
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new ColorIterator();
    }

    //this is a smart object that can return
    //the components from an RgbColor object
    private class ColorIterator implements Iterator<Integer>
    {
        private int[] components;
        private int position = 0;

        public ColorIterator()
        {
            components = new int[] {red, green, blue};
        }

        @Override
        public boolean hasNext()
        {
            return position < components.length;
        }

        @Override
        public Integer next()
        {
            int nextComponent = components[position];
            position++;
            return nextComponent;
        }
    }
}
