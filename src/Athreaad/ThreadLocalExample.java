package Athreaad;

import java.text.SimpleDateFormat;
import java.util.Random;
/*
为什么key使用弱引用
不妨反过来想想，如果使用强引用，当ThreadLocal对象（假设为ThreadLocal@123456）的引用（即：TL_INT，是一个强引用，指向ThreadLocal@123456）被回收了，ThreadLocalMap本身依然还持有ThreadLocal@123456的强引用，如果没有手动删除这个key，则ThreadLocal@123456不会被回收，所以只要当前线程不消亡，ThreadLocalMap引用的那些对象就不会被回收，可以认为这导致Entry内存泄漏。

那使用弱引用的好处呢？

如果使用弱引用，那指向ThreadLocal@123456对象的引用就两个：TL_INT强引用，和ThreadLocalMap中Entry的弱引用。一旦TL_INT被回收，则指向ThreadLocal@123456的就只有弱引用了，在下次gc的时候，这个ThreadLocal@123456就会被回收。

那么问题来了，ThreadLocal@123456对象只是作为ThreadLocalMap的一个key而存在的，现在它被回收了，但是它对应的value并没有被回收，内存泄露依然存在！而且key被删了之后，变成了null，value更是无法被访问到了！针对这一问题，ThreadLocalMap类的设计本身已经有了这一问题的解决方案，那就是在每次get()/set()/remove()ThreadLocalMap中的值的时候，会自动清理key为null的value。如此一来，value也能被回收了。

既然对key使用弱引用，能使key自动回收，那为什么不对value使用弱引用？答案显而易见，假设往ThreadLocalMap里存了一个value，gc过后value便消失了，那就无法使用ThreadLocalMap来达到存储全线程变量的效果了。（但是再次访问该key的时候，依然能取到value，此时取得的value是该value的初始值。即在删除之后，如果再次访问，取到null，会重新调用初始化方法。）

key是弱引用，value是强引用，没有value的时候可以删除key
ThreadLocal最好还是不要和线程池一起使用，就没这么多问题了
 */
public class ThreadLocalExample implements Runnable{

    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));



    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 6);
    private static final ThreadLocal<String> TL_STRING = ThreadLocal.withInitial(() -> "Hello, world");






    public static void main(String[] args) throws InterruptedException {


        // 6
        System.out.println(TL_INT.get());
        TL_INT.set(TL_INT.get() + 1);
        // 7
        System.out.println(TL_INT.get());
        TL_INT.remove();
        // 会重新初始化该value，6
        System.out.println(TL_INT.get());


        ThreadLocalExample obj = new ThreadLocalExample();

        for(int i=0 ; i<5; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }



}
