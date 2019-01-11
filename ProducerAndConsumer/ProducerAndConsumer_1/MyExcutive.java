package ProducerAndConsumer.ProducerAndConsumer_1;

import java.util.concurrent.*;

public class MyExcutive {
    public static void main(String[] args) throws InterruptedException {
        //The optional capacity bound constructor argument serves as a way to prevent excessive expansion
        BlockingQueue<Data> blockingQueue=new LinkedBlockingDeque<>(10);
        Producer p1=new Producer(blockingQueue);
        Producer p2=new Producer(blockingQueue);
        Producer p3=new Producer(blockingQueue);
        Consumer c1=new Consumer(blockingQueue);
        Consumer c2=new Consumer(blockingQueue);
        Consumer c3=new Consumer(blockingQueue);
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);
        Thread.sleep(5);
        p1.isStop();
        p2.isStop();
        p3.isStop();
        Thread.sleep(5);
        //This method does not wait for previously submitted tasks to complete execution.
        service.shutdown();
    }
}
