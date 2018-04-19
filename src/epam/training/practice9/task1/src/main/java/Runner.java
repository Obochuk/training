package epam.training.practice9.task1.src.main.java;

public class Runner {

    public static void run(){
        new Thread(() ->{
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb!");
        }).start();
    }

}
