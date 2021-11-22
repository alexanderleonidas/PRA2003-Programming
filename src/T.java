public class T {
    public static void methodA(int a){
        try{
            methodB(a);
        } catch(final Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        
    }

    public static void methodB(int b) throws Exception {
        methodC(b);
    }

    public static void methodC(int c) throws Exception {
        if(c == 0) {
           throw new Exception("Argument is 0!");
        }
    }

    public static void main(String[] args) {
        methodA(0);
    }
}

/**
 * The most useful method for printing out Exceptions depends on the aim of the program, 
 * for testing the e.printStackTrace(); is more useful as it gives a full detail of which lines
 * are included, whereas the seconf one is more clean and esaier for users to uderstand.
 */
