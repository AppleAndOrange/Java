package ProducerAndConsumer.ProducerAndConsumer_1;

public class Data {
    int data;
    Data(Object data){
        this.data=Integer.parseInt(data.toString());
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
