package ProducerAndConsumer.ProducerAndConsumer_2;

public class Data {
    int data;
    Data(Object data){
        data=Integer.parseInt(data.toString());
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
