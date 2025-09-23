package multithreading.methods;

public class MyThread extends Thread {

    @Override
    public void run(){
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThread t1 = new MyThread();
        t1.start();
        t1.join();
        System.out.println("Hello");
    }
}
