package HW4_Threads;


class MyThread extends Thread {
    private Object obj;
    public MyThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
//        while (true) {
            synchronized (obj) {
//                try {
                    System.out.println(getName());
                    obj.notify();
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Object obj = new Object();
        new MyThread(obj).start();
        new MyThread(obj).start();
    }
}
