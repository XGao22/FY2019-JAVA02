/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-04-02 10:32
 **/
public class Test_Deadlock {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public static void main(String[] args) {
        Test_Deadlock lock = new Test_Deadlock();
        Thread thread1 = new Thread(new myRunnable1(lock.obj1, lock.obj2),"THREAD-1");
        Thread thread2 = new Thread(new myRunnable2(lock.obj1, lock.obj2),"THREAD-2");
        thread1.start();
        thread2.start();
    }
}

class myRunnable1 implements Runnable {

    Object obj1;
    Object obj2;

    public myRunnable1() {

    }

    public myRunnable1(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {

        synchronized (obj1){
            System.out.println(Thread.currentThread().getName()+"obj1锁住了，休息1秒钟后锁obj2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName()+"obj2也锁住了");
            }
        }
    }
}

class myRunnable2 implements Runnable {

    Object obj1;
    Object obj2;

    public myRunnable2() {

    }

    public myRunnable2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {

        synchronized (obj2){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"obj2锁住了，休息0.5秒后锁obj1");
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName()+"obj1也锁住了");
            }
        }
    }
}

