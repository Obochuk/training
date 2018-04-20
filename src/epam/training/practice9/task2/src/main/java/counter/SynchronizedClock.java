package src.main.java.counter;

public class SynchronizedClock implements Runnable {
    private final int COUNT_TO = 1_000;

    private int value = 0;
    private boolean counterFinished = false;
    private boolean counterStarted = false;

    @Override
    public void run() {
        new Thread(() -> {   // counter
            synchronized (this) {
                counterStarted = true;
                while (value < COUNT_TO)
                    try {
                        wait();
                        value++;
                        notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                counterFinished = true;
            }
        }).start();

        new Thread(() -> {   // printer
            synchronized (this) {
                while (!counterFinished) {
                    try {
                        System.out.println(value);
                        notify();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
