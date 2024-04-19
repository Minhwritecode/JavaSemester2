package Thread;

public class Buffer {
    private Integer data = null;

    public synchronized void put(int newData) {
        while (data != null) {
            try {
                wait(); // Đợi cho đến khi Buffer trống
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = newData;
        System.out.println("Produced: " + data);
        notify(); // Thông báo cho Consumer biết có dữ liệu để tiêu thụ
    }

    public synchronized int get() {
        while (data == null) {
            try {
                wait(); // Đợi cho đến khi có dữ liệu
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int returnValue = data;
        data = null;
        System.out.println("Consumed: " + returnValue);
        notify(); // Thông báo cho Producer biết Buffer đã trống
        return returnValue;
    }
}

