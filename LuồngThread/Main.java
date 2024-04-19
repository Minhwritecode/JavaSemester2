package LuồngThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Luồng 1: Nhập 2 cạnh hình chữ nhật
        Thread thread1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập cạnh 1: ");
            double canh1 = scanner.nextDouble();
            System.out.print("Nhập cạnh 2: ");
            double canh2 = scanner.nextDouble();
            // Luồng 2: Tính diện tích hình chữ nhật
            Thread thread2 = new Thread(() -> {
                double dienTich = canh1 * canh2;
                // Luồng 4: Hiển thị kết quả diện tích
                Thread thread4 = new Thread(() -> {
                    System.out.println("Diện tích: " + dienTich);
                });
                thread4.start();
            });
            thread2.start();
            // Luồng 3: Tính chu vi hình chữ nhật
            Thread thread3 = new Thread(() -> {
                double chuVi = 2 * (canh1 + canh2);
                // Luồng 4: Hiển thị kết quả chu vi
                Thread thread4 = new Thread(() -> {
                    System.out.println("Chu vi: " + chuVi);
                });
                thread4.start();
            });
            thread3.start();
        });
        thread1.start();
    }
}