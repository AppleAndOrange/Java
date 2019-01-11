package ProducerAndConsumer.ProducerAndConsumer_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {
    List<Data> list;
    private AtomicInteger inc=new AtomicInteger();
//    int inc=0;

    Producer(List<Data> list){
        this.list=list;
    }
    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted())
                break;
            synchronized (list){
                Data data=new Data(inc.incrementAndGet());
                System.out.println("线程"+Thread.currentThread().getId()+"生产了"+data.getData());
                try {
                    if(list.size()>=10){
                        list.notifyAll();//唤醒因list而阻塞的线程
                        list.wait();//使因缺少list而等待
                    } else {
                        list.add(data);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
