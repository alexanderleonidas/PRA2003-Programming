class Fibonacci{
    public static long fibonacciI(int n){
        int[] fib = new int[n+1];
        fib[0] = 1;
        fib[1] = 1;
        if(n == 0) {
            return fib[0];
        } else if (n == 1) {
            return fib[1];
        } else if (n < 0){
            System.out.println("A negative index is not allowed, please choose a positive index!");
            return (Long) null;
        } else if (n > 91) {
            System.out.println("The index is too large. Indexes up to 91 are only supported");
            return (Long) null;
        } else {
            for(int i = 2; i <=n; i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
        }
        return fib[n];    
    }

    public static long fibonacciR(int n){
        if(n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n < 0){
            System.out.println("A negative index is not allowed, please choose a positive index!");
            return (Long) null;
        } else if (n > 91) {
            System.out.println("The index is too large. Indexes up to 91 are only supported");
            return (Long) null;
        } else {
            return fibonacciR(n-2) + fibonacciR(n-1);
        }
    }

    public static void main(String[] args) {
        long startAt = System.nanoTime();
        System.out.println(fibonacciI(45));
        double secs = (System.nanoTime() - startAt) / 1000000000.0;
        System.out.println(secs);

        long startAt1 = System.nanoTime();
        System.out.println(fibonacciR(45));
        double secs1 = (System.nanoTime() - startAt1) / 1000000000.0;
        System.out.println(secs1);

        /**
         * Q1) All functions are static because they can be called without creating an instance, they are not associated with
         * the object, non-static methods cannot access variables from the static function, and static functions only 
         * access static members.
         * Q2) The functions return long type instead of int type becasue a long can represent larger numbers,
         * for example they can store numbers that take up to 8 bytes which is 2^64 whereas int type only stores numbers up to 2^32.
         * Q3) The process suited best for the calculation of the nth term in the fibonacci sequence is the iterative method 
         * because it takes the least time to perform this calculation.
         * Q4) The recursive method is much slower then the iterative method because the time complexity for this recursive method 
         * is exponential and he time complexity for the iterative method is polynomial or logarithmic.
         */

    }
}