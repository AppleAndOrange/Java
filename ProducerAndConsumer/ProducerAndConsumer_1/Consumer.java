package ProducerAndConsumer.ProducerAndConsumer_1;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    private BlockingQueue<Data> queue;
    private int sleepTime=1000;
    Consumer(BlockingQueue<Data> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程  name="+Thread.currentThread().getName());
        while (true){
            try {
                Data data=queue.take();
                if(data!=null){
                    System.out.println("该消费者消费了产品"+data.getData());
//                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
