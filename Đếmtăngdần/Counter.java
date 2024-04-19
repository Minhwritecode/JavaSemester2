package Đếmtăngdần;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Tạo các thread thực hiện việc tăng giá trị đếm
        Runnable task = () -> {
            for(int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        // Khởi động các thread
        t1.start();
        t2.start();

        // Chờ đợi cho đến khi cả hai thread hoàn thành
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In giá trị cuối cùng của count
        System.out.println("Final count: " + counter.count);
    }
}

