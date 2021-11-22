import java.util.Random;

public class LotteryThread extends Thread{
    public LotteryThread(final String str) {
        super(str);
    }

    @Override
    public void run(){
        Random rnd = new Random();
        for(int i = 1; i <11; i++){
            try {
                sleep(rnd.nextInt(1000));
                System.out.println("Iteration " + i + " of " + this.getName());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class LotterThreads{
    public static void main(String[] args) {
        LotteryThread t1 = new LotteryThread("One");
        LotteryThread t2 = new LotteryThread("Two");
        LotteryThread t3 = new LotteryThread("Three");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
