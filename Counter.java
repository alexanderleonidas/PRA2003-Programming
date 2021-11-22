/**
 * PRA2003 Task 5.1: Code to confuse thread counters.
 * @author cambolbro (based on https://surfdrive.surf.nl/files/index.php/s/6s9JNxqkdyz9IKy)
 */
public class Counter
{
    private int count = 0;

    //-------------------------------------------------------------------------
    
    /**
     * Increment the count.
     */
    public void increment() 
    {
        synchronized(this){ // Adding this solves of prbolem in Q2
   		    count++;
        }
    }

    /**
     * Decrement the count.
     */
    public void decrement() 
    {
        synchronized(this){
            count--;
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Test method to do the work.
     */
    void test()
    {
       	final int numRuns = 1000;
    	
        final Thread threadA = new Thread() 
        {
        	@Override
            public void run() 
        	{
                for (int i = 1; i <= numRuns; i++) 
                    increment();
            }
        };

        final Thread threadB = new Thread() 
        {
        	@Override
            public void run() 
        	{
                for (int i = 1; i <= numRuns; i++) 
                    decrement();
             }
        };

        // Start the threads...
        threadA.start();
        threadB.start();
        
        // ...then use join() to make sure they've finished
        try
        {
        	threadA.join();
        	threadB.join();
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println(count);
    }

    //-------------------------------------------------------------------------

    /**
     * Main entry point.
     */
    public static void main(final String[] args) 
    {
    	final Counter app = new Counter();
    	app.test();
    }
}
 
/**
 * Q1) Running this program several times gives output values other then zero
 * such as -56 and -41
 * Q2) The reason this behviour happens is becasue the two threads may
 * try to access the same data at the same moment in time. This can happen
 * when one of the threads access the data before the other thread could save
 * the new value of the counter.
 * Q3) It is better to synchronise blocks of code rather then methods because,
 * synchronising the method locks the entire object so it cannot be used if 
 * another thread reqires that method. Synchronising code blocks does not give
 * this effect.
 */