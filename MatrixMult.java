/**
 * Exercise for PRA2003 task 1.2
 * @author cambolbro
 */
class Matrix 
{ 
	private int rows, cols; 
	private int[][] elements; 

	Matrix(final int rows, final int cols) 
	{ 
		this.rows = rows;
		this.cols = cols; 
		
		// Create a two-dimensional array of integers
		elements = new int[rows][cols];
	}

	//-------------------------------------------------------------------------

	public int getRows() { return rows; }
	public int getCols() { return cols; }

	public int get(final int r, final int c) 
	{ 
		return elements[r][c]; 
	}

	public void set(final int r, final int c, final int value) 
	{ 
		elements[r][c] = value; 
	}

	//-------------------------------------------------------------------------

	public static Matrix multiply(final Matrix left, final Matrix right) 
	{
		// Complete this method
		final int m = left.getRows(); 
		final int n = left.getCols();
		final int p = right.getCols(); 

		// Add code here that builds the product matrix and returns it
		
		// First, create the new product matrix
		Matrix product = new Matrix(m,p);
		
		// Then, use a triple-nested loop:
		// - The first two iterate over the rows (i) and columns (j) of the product matrix
		// - The innermost loops computes the value of the element using the sum over n 
		for(int i = 0; i < m; i++){
			for(int j = 0; j < p; j++) {
				int sum = 0;
				for(int k = 0; k < n; k++) {
					sum += left.get(i, k) * right.get(k, j);
				}
				product.set(i, j, sum);
			}
		}
		
		return product;  // return your result instead
	}
		
	//-------------------------------------------------------------------------

	// Sets all the entries at once, starting at topleft, in reading order
	public void setAll(final int[] entries) 
	{ 
		if (entries.length != rows * cols) 
		{ 
			System.out.println("setAll() error, wrong number of entries!"); 
			System.exit(-1); 
		} 
		
		for (int i = 0; i < entries.length; i++) 
		    elements[i / cols][i % cols] = entries[i];  // i/cols gives row, i%cols gives column
	}
		
	public String toString() 
	{ 
		final StringBuilder sb = new StringBuilder();
		for (int r = 0; r < rows; r++) 
		{ 
			for (int c = 0; c < cols; c++) 
				sb.append(elements[r][c] + " ");
			sb.append("\n");  // newline after each row
		}
		return sb.toString(); 
	}
}

//-----------------------------------------------------------------------------

/**
 * Main class
 */
class MatrixMult 
{
	public static void main(final String[] args) 
	{ 
		final Matrix A = new Matrix(3,2);   // create an empty 3-by-2 matrix
		A.setAll(new int[]{3, 1, -1, 0, 4, 2});  // set the values, in reading order
		System.out.println("A:\n" + A);
    
		final Matrix B = new Matrix(2,3);
		B.setAll(new int[]{0, 2, -3, -2, 5, 1}); 
		System.out.println("B:\n" + B);

		final Matrix product = Matrix.multiply(A,B); 
		System.out.println("AxB:");
		System.out.println(product);

		final Matrix D = new Matrix(3,3);
		D.setAll(new int[]{2, -2, 4, 0, 1, 3, 5, 2, -1}); 
		System.out.println("\nD:\n" + D);

		final Matrix E = new Matrix(3,3);
		E.setAll(new int[]{0, 1, 2, 3, -2, 4, 5, -3, 0}); 
		System.out.println("E:\n" + E);

		final Matrix DE = Matrix.multiply(D,E); 
		System.out.println("DxE:");
		System.out.println(DE);
   }
}
