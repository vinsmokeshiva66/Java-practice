public class Threadclient {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        MyRunnable runnable=new MyRunnable();
        Thread thread1=new Thread(runnable);
        thread.start();
        thread1.start();
    }
}
