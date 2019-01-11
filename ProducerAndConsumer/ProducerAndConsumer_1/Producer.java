package ProducerAndConsumer.ProducerAndConsumer_1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread{
    private BlockingQueue<Data> queue;
    private Data data;
    private volatile boolean run=true;
    private AtomicInteger count=new AtomicInteger();
    private int sleepTime=1000;

    Producer(BlockingQueue<Data> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        System.out.println("生产者线程  name="+Thread.currentThread().getName());
        while (run){
            try {
//                Thread.sleep(sleepTime);
                data=new Data(count.incrementAndGet());
                System.out.println("生产者 "+data.getData()+"加入队列");
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("加入失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void isStop(){
        run=false;
    }
}
