/**
 * @program: Test
 * @description
 * @author: X.Gao
 * @create: 2019-03-30 10:47
 **/
public class Test_Thread {

    public static void main(String[] args){

        new MyThread().start();
        test();

    }

    static void test(){
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}

class MyThread extends Thread{
    public void run(){
        for (int i=0;i<100;i++){
            System.out.println("Thread:"+i);
        }
    }
}
