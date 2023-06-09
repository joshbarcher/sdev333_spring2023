package coffee;

public class CupOfCoffee /*implements Comparable<CupOfCoffee>*/
{
    private String type;
    private int sizeOunces;
    private double price;
    private boolean hot;

    public CupOfCoffee(String type, int sizeOunces, double price, boolean hot)
    {
        this.type = type;
        this.sizeOunces = sizeOunces;
        this.price = price;
        this.hot = hot;
    }

    /*@Override*/
    public int compareTo(CupOfCoffee otherCup)
    {
        /*if (price < otherCup.price)
        {
            return -1;
        }
        else if (price > otherCup.price)
        {
            return 1;
        }
        else //they are the same
        {
            return 0;
        }*/

        /*return (int) (price * 100 - otherCup.price * 100);*/

        return type.compareTo(otherCup.type);
    }

    public String getType()
    {
        return type;
    }

    public int getSizeOunces()
    {
        return sizeOunces;
    }

    public double getPrice()
    {
        return price;
    }

    public boolean isHot()
    {
        return hot;
    }

    @Override
    public String toString()
    {
        return "CupOfCoffee{" +
                "type='" + type + '\'' +
                ", sizeOunces=" + sizeOunces +
                ", price=" + price +
                ", hot=" + hot +
                '}';
    }
}
