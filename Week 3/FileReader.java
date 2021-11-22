import java.io.*;

/**
 * PRA2003 2021: Task 3.3.
 * @author: cambolbro (based on previous years' code). 
 */
class FileReader 
{
    private final String inputFileName;
    private final String outputFileName;

    //-------------------------------------------------------------------------
    
    public FileReader(final String inFileName, final String outFileName) 
    {
        this.inputFileName = inFileName;
        this.outputFileName = outFileName;
    }

    //-------------------------------------------------------------------------

    /**
     * Parse the input file.
     */
    public void parse() 
    {
        // Open the input stream using the input file name
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName))); 
        PrintWriter out = new PrintWriter(outputFileName);){
            String line = in.readLine();

            // Read line-by-line, printing out each line, until there are no more lines
            while (line != null) 
            {
                // Make sure 
                if(line.toLowerCase().contains(" heat ")){
                    // Add to the output file if the word heat is in the line
                    out.println(line);
                }
                //System.out.println(line);
                line = in.readLine();
            }
        }
        catch (final Exception e) 
        {
            System.out.println("An error occurred: ");
            e.printStackTrace();
            // All methods inherit this method (printStackTrace() from Throwable).
            // This method prints the stack trace of the Exception to System.err.
            // It tells us what happened and where in the code this happened.
        }
    }

    //-------------------------------------------------------------------------

    /**
     * Main program entry point.
     */
    public static void main(String[] args) throws IOException 
    {
        final FileReader app = new FileReader("pepper.txt", "pepper_out.txt");
        app.parse();
    }
}
