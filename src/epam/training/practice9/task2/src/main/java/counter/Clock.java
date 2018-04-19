package epam.training.practice9.task2.src.main.java.counter;

public class Clock implements Runnable {
    private final int COUNT_TO = 1_000;

    private int value = 0;
    private boolean valuePrinted = false;
    private boolean counterFinished = false;

    @Override
    public void run() {
        new Thread(() ->{   // counter
            while (value < COUNT_TO) {
                if (valuePrinted) {
                    value++;
                    valuePrinted = false;
                }
            }
            counterFinished = true;
        }).start();

        new Thread(() ->{   // printer
            while (!counterFinished || ! valuePrinted){
                if (!valuePrinted){
                    System.out.println(value);
                    valuePrinted = true;
                }
            }
        }).start();
    }
}
