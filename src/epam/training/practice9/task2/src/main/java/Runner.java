package src.main.java;


import src.main.java.counter.SynchronizedClock;

public class Runner {

    public static void run() {
        /*System.out.println("Not synchronized clock: ");
        new Thread(new Clock()).start();*/


        System.out.println("Synchronized clock: ");
        new Thread(new SynchronizedClock()).start();
    }

}
