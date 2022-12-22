package HW4_Threads;
//Дано два потока — производитель и потребитель.
// Производитель генерирует некоторые данные (в примере — числа).
// Производитель «потребляет» их.
// Два потока разделяют общий буфер данных, размер которого ограничен.
// Если буфер пуст, потребитель должен ждать, пока там появятся данные.
// Если буфер заполнен полностью, производитель должен ждать,
// пока потребитель заберёт данные и место освободится.

import java.nio.ByteBuffer;

import static java.lang.Thread.sleep;

class Consumer implements Runnable {
    ByteBuffer buffer;

    Consumer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(500);
                System.out.println("Потребитель: Жду данные");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            if (buffer.position() == buffer.capacity()) {
                System.out.println("Потребитель: Жду очистки буфера");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Потребитель: получил данные " + buffer.get());
            }

        }
    }
}

class Producer extends Thread {
    ByteBuffer buffer;

    Producer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (byte i = 0; i < 10; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("buffer.position=" + buffer.position() + "\ncapacity=" + buffer.capacity());
            if (buffer.position() == buffer.capacity()) {
                System.out.println("Производитель: Очистка буфера");
                buffer.clear();
            }
            buffer.put(i);
            System.out.println("Производитель: положил данные в буффер: " + i);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        Producer myProducer = new Producer(buffer);
        Consumer myConsumer = new Consumer(buffer);
        new Thread(myProducer).start();
        new Thread(myConsumer).start();
    }
}
