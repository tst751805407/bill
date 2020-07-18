package 手撕代码;

import java.util.concurrent.BlockingQueue;

public class prod implements Runnable {
    private final BlockingQueue blockingQueue;
    private int task=1;
    public prod(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true){

            try {
                System.out.println("正在生产："+task);
                blockingQueue.put(task);
                task++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
