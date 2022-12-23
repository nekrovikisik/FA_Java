// Напишите программу, в которой создаются два потока,
// которые выводят на консоль своё имя по очереди.


package HW_4_Threads;


class MyThread extends Thread {
    private Object obj;
    public MyThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            System.out.print(getName());
            obj.notify();
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        Object obj = new Object();
        new MyThread(obj).start();
        new MyThread(obj).start();
    }
}
