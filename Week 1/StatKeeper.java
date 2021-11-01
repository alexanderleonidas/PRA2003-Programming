import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream; 

/**
 * A class to keep track of statistics for a list of numbers.
 * For PRA2003, based on code from previous years.
 * author: Alexander Leonidas
 */
class StatKeeper 
{ 
	private List<Integer> list = new ArrayList<Integer>(); 
 
   	// Add an integer to the list
  	public void add(final int x) 
  	{ 
	  list.add(x); 
  	}

  	// @return Minimum value in the list.
  	public int getMin() {	 
  		int min = Integer.MAX_VALUE; 
    	for (int x : list)  
  			if (x < min)  
  				min = x; 
    	return min; 
	}

	// Method that calculates the mean of an array
    public static float Mean(List<Integer> data) {
		if (data.size() == 0) {
			System.out.println("Array has no values. please try again");
			return 0;
		} else {
			int sum = 0;
			for(int i = 0; i < data.size(); i++){
				sum += data.get(i);
			}
			return (float)sum/data.size();
		}
        
    }

	// Method to calculate the variance
    public static float Variance(List<Integer> data){
        float mean = Mean(data);
        float temp = 0;
        for(int i = 0; i < data.size(); i++){
            temp += Math.pow(data.get(i) - mean, 2);
        }
        return temp/data.size();
    }

	//Method to calculate the standard deviation
    public static float StandardDeviation(List<Integer> data){
		float vari = Variance(data);
		return (float)Math.sqrt(vari);
    }

	// Method that computes width of an 95% confidnce interval for the mean of an array
	public static float Width(List<Integer> data){
		float std = StandardDeviation(data);
		return (float)(1.96*std/Math.sqrt(data.size()));
	}

	public static void main(String[] args) {
		StatKeeper stat = new StatKeeper();
		stat.add(72);
		stat.add(81);
		stat.add(65);
		stat.add(93);
		stat.add(88);
		stat.add(21);
		stat.add(45);
		stat.add(28);
		stat.add(89);
		stat.add(67);
		System.out.println(Mean(stat.list));
		System.out.println(Variance(stat.list));
		System.out.println(StandardDeviation(stat.list));
		System.out.println(Width(stat.list));

		
    }
}

