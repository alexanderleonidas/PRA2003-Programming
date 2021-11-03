import java.util.Arrays;
import java.util.Date;

/**
 * PRA2003 Week 2, Task 3: Comparable objects.
 * @author Alexander Leonidas
 */

//-----------------------------------------------------------------------------

/**
 * Abstract superclass for deriving Comparable object classes.
 */
abstract class Comparable 
{
    /**
     * @return True if this object >= other.
     */
    public abstract boolean greaterThan(final Comparable other);

    /** 
     * @return String description of object.
     */
    public abstract String toString();
}

//-----------------------------------------------------------------------------

/**
 * Class that compares details of a song
 */
class Song extends Comparable{
    String name;
    int year;

    public Song(String name, int year){
        this.name = name;
        this.year = year;
    }

    //Compare A song with another 
    @Override
    public boolean greaterThan(final Comparable other){
        final Song otherSong = (Song)other;
        return year > otherSong.year 
                || 
                year == otherSong.year 
                && 
                name.compareTo(otherSong.name) > 0;
    }

    @Override
    public String toString(){
        return "The song " + "'" + name + "'" + " was made in " + year; 
    }

}

// Class that compares details about students
class Student extends Comparable{
    String name;
    double grade;

    public Student(String name, double grade){
        this.name = name;
        this.grade = grade;
    }

    @Override
    public boolean greaterThan(final Comparable other){
        final Student otherStudent = (Student)other;
        return ((grade > otherStudent.grade) || (grade == otherStudent.grade && name.compareTo(otherStudent.name)>0));
    }

    @Override
    public String toString(){
        return "The student " + name + " has an average grade of " + grade; 
    }
}

//-----------------------------------------------------------------------------

/**
 * Main program class.
 */
public class Sort 
{
	/**
	 * Sorts the elements in the array in ascending order.
	 */
    public static void bubbleSort(final Comparable[] array) 
    {
        boolean didSwap; 
        do 
        {
            didSwap = false; 
            for (int i = 0; i < array.length - 1; i++) 
                if (array[i].greaterThan(array[i + 1])) 
                { 
                    // Swap these two elements
                    final Comparable tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp; 
                    didSwap = true;
                }
        } while (didSwap);
    }
	
    public static void main(final String[] args)
    {
       final Comparable[] students = 
       { 
           new Student("Jerry",  8.7),
           new Student("Jerrry", 8.7), 
           new Student("David",  8.0),
           new Student("Gloria", 9.0) 
       };
       bubbleSort(students);
       System.out.println(Arrays.toString(students));
		
       final Comparable[] songs = 
       { 
           new Song("Seven Nation Army",   2003), 
           new Song("The Real Slim Shady", 2000), 
           new Song("Wonderwall",          1995),
           new Song("Karma Police",        1997) 
       };
       bubbleSort(songs);
       System.out.println(Arrays.toString(songs));
    }
}

