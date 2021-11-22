/**
 * PRA2003 2021 Task 3.1: Exceptions example.
 * @autho cambolbro (based on Eck book Sec 8.3.2)
 */
//-----------------------------------------------------------------------------

/**
 * This class extends the Exception class.
 * Exceptions are like normal classes, so custom exceptions can have fields, 
 * constructors, methods, etc.
 */
class IllegalArgumentException extends Exception 
{
    private String problem;

    IllegalArgumentException(final String problem) 
    { 
        this.problem = problem;
    }

    @Override
    public String toString() 
    {
        return "IllegalArgumentException: " + problem;
    }
}

//-----------------------------------------------------------------------------

/**
 * Demonstrates the use of our custom Exception.
 */
class Exceptions 
{  
	/**
	 * @return Larger of the two roots of the quadratic equation a*x*x + b*x + c = 0, 
	 *         provided it has any roots.
	 */
    public static double root(final double a, final double b, final double c) throws IllegalArgumentException 
    {
        if (a == 0) 
        	throw new IllegalArgumentException("a can't be zero.");
        
        double disc = b * b - 4 * a * c;
        if (disc < 0)
        	throw new IllegalArgumentException("Discriminant < zero.");

        return (-b + Math.sqrt(disc)) / (2 * a);
    }

    //-------------------------------------------------------------------------

    public static void main(String[] args) 
    {
        try 
        {
            System.out.println(root(0, 5, 6));
        }
        catch (final IllegalArgumentException e) 
        {
            // This catches only IllegalArgumentExceptions.
            System.out.println(e);
        }
        catch (final Exception e) 
        {
            // This case catches every kind of exception.
            System.out.println(e);
        }

        try 
        {
            System.out.println(root(1, 0, 3));
        }
        catch (final IllegalArgumentException e) 
        {
            // This catches only IllegalArgumentExceptions.
            System.out.println(e);
        }
       
        try 
        {
            System.out.println(root(2, 5, 2));
        }
        catch (final IllegalArgumentException e) 
        {
            // This catches only IllegalArgumentExceptions.
            System.out.println(e);
        }

        try{
            int[] array = null;
            System.out.println(array.length);

            int[] values = {0, 10, 20};
            values[3] = 30;

        } catch(final ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch(final NullPointerException e) {
            System.out.println(e);
        }
    }    
}
/**Questions
 * Q1) There is an error becasue the IllegalArgumentException is already handeled by the first catch block
 * Q2) I predict that there will be an error message saying it is not possible get the size, and when the code 
 * was run there ws the error that an array of length zero cannot be read.
 * Q3) I predict that there will be error message saying that there is no index 3. When running this is exaclty the error I get.
 * Q4) The error occurs in the first two lines, this is becasue the code will stop when an error is encountered and hence,
 * leave out the rest of the catch blocks. Commenting out the lines gives no error messages becasue there is no code that is run. 
 * Switching the catch blocks still gives the NullPointerException error becasue that is the code that is run first in the try block.
 */
