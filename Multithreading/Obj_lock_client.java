public class Obj_lock_client{
    public static void main(String[] args) {
        Obj_lock lock=new Obj_lock();
    Thread t1=new Thread(() -> lock.display("Thread 1"));
    Thread t2=new Thread(() -> lock.display("Thread 2"));
    t1.start();
    t2.start();
    }
}
