package ProducerAndConsumer.ProducerAndConsumer_2;

import java.util.List;

public class Consumer extends Thread {
    List<Data> list;
    Consumer(List<Data> list){
        this.list=list;
    }

    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted())
                break;
            Data data;
            synchronized (list){
                try {
                    if(list.size()<10){
                        list.wait();
                        list.notifyAll();

                    }
                    data=list.remove(0);
                    System.out.println("消费者"+Thread.currentThread().getId()+"消费了"+data.getData());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
