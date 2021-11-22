import java.util.concurrent.CountDownLatch;

/**
 * PRA2003 Task 5.3: Sleepy threads app.
 * @author cambolbro
 */
public class Sleepy 
{
	/**
	 * Puts some threads to sleep.
	 * @param nums Array of non-negative integers.
	 */
	public static void sleepy(final int[] nums) 
	{
		final CountDownLatch latch = new CountDownLatch(nums.length);

		for (final int n : nums) 
			new Thread(new Runnable() 
			{
				// Create a new thread for each value
				public void run() 
				{
					// Use that value as a delay
					try 
					{ 
						latch.countDown();
						Thread.sleep((n < 0) ? 0 : n * 3); 
						latch.await();
					} 
					catch (InterruptedException e) 
					{ 
						e.printStackTrace(); 
					}
					System.out.println(n);
				}
			}).start();  // start the thread immediately
	}
	
	/**
	 * Main entry point.
	 */
	public static void main(String[] args) 
	{
		final int[] nums = { 3, 8, 1, 2, 7, 12 };  // <= insert small non-negative integers here
		sleepy(nums);
	}
}

/**
 * Q1) This code outputs integer numbers in numerical order. Inserting
 * negative numbers outputs them first without any delay (sleep).
 * Q2) Reducing the sleep to 1 milisecond will mess up the order of the 
 * integers
 */
