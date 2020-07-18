package 手撕代码;

import java.util.concurrent.LinkedBlockingQueue;

public class main {
    public static void main(String[] args){
        LinkedBlockingQueue blockingQueue=new LinkedBlockingQueue(5);
        conss con=new conss(blockingQueue);
        prod prod=new prod(blockingQueue);

    }


}
