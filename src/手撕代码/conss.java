package 手撕代码;

import java.util.concurrent.BlockingQueue;

public class conss implements Runnable{
    private final BlockingQueue blockingQueue;

    conss(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }

    public void run(){
        while (true){
            try {
                System.out.println("消费："+blockingQueue.take());
                Thread.sleep(1100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

