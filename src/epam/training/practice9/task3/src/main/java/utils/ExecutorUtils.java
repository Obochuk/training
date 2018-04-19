package src.main.java.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorUtils {

    public static long ExecuteAndReturnTime(List<Runnable> runnables) {
        final int THREAD_AMOUNT = runnables.size();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_AMOUNT);
        long startTime = System.currentTimeMillis();
        executeAll(runnables, service);
        service.shutdown();
        try {
            service.awaitTermination(5, TimeUnit.MINUTES);
            return System.currentTimeMillis() - startTime;
        } catch (InterruptedException ignored) {
            return 0;
        }
    }


    public static void executeAll(List<Runnable> runnables, ExecutorService executorService) {
        for (Runnable runnable : runnables) {
            executorService.execute(runnable);
        }
    }

}
