package Thread;

public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

