package 手撕代码;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者模式
 * 使用阻塞队列BlockingQueue
 * @author wanggenshen
 *
 */
public class Producerconsumer {

    public static void main(String[] args){
        BlockingQueue blockingQueue = new LinkedBlockingQueue(5);

        Producer p = new Producer(blockingQueue);
        Consumer c = new Consumer(blockingQueue);

        Thread tp = new Thread(p);
        Thread tc= new Thread(c);

        tp.start();
        tc.start();
    }
}

/*
public static void main(String args[]) throws InterruptedException {
	// 1.构建内存缓冲区
	BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

	// 2.建立线程池和线程
	ExecutorService service = Executors.newCachedThreadPool();
	Producer prodThread1 = new Producer(queue);
	Producer prodThread2 = new Producer(queue);
	Producer prodThread3 = new Producer(queue);
	Consumer consThread1 = new Consumer(queue);
	Consumer consThread2 = new Consumer(queue);
	Consumer consThread3 = new Consumer(queue);
	service.execute(prodThread1);
	service.execute(prodThread2);
	service.execute(prodThread3);
	service.execute(consThread1);
	service.execute(consThread2);
	service.execute(consThread3);

	// 3.睡一会儿然后尝试停止生产者
	Thread.sleep(10 * 1000);
	prodThread1.stop();
	prodThread2.stop();
	prodThread3.stop();

	// 4.再睡一会儿关闭线程池
	Thread.sleep(3000);
	service.shutdown();
}

 */


