package ProducerAndConsumer.ProducerAndConsumer_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExcutive {
    public static void main(String[] args) {
        List<Data> list=new ArrayList<>();
//        Producer p1=new Producer(list);
//        Producer p2=new Producer(list);
//        Producer p3=new Producer(list);
//        Consumer c1=new Consumer(list);
//        Consumer c2=new Consumer(list);
//        Consumer c3=new Consumer(list);
//        ExecutorService service= Executors.newCachedThreadPool();
//        service.execute(p1);
//        service.execute(p2);
//        service.execute(p3);
//        service.execute(c1);
//        service.execute(c2);
//        service.execute(c3);
        Producer p[]=new Producer[2];
        Consumer c[]=new Consumer[2];
        for(int i=0;i<2;i++){
            p[i]=new Producer(list);
            c[i]=new Consumer(list);
            p[i].start();
            c[i].start();
        }
    }
}
