package comparators.practice.albums;

/**
 * Represents an album of music.
 *
 * DO NOT EDIT THIS FILE!
 */
public class Album
{
    private String title;
    private int yearReleased;
    private double minutes;
    private boolean completed;

    public Album(String title, int yearReleased,
                 double minutes, boolean completed)
    {
        this.title = title;
        this.yearReleased = yearReleased;
        this.minutes = minutes;
        this.completed = completed;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYearReleased()
    {
        return yearReleased;
    }

    public double getMinutes()
    {
        return minutes;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    @Override
    public String toString()
    {
        String completed = this.completed ? " (complete)" : " (incomplete)";
        return title + " (" + yearReleased + ") (" + minutes + " mins)" +
               completed;
    }
}
