package lesson;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] source = {1, 2, 3, 4};

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        final int[] res1 = new int[source.length / 2];
        final int[] res2 = new int[source.length / 2];

        System.arraycopy(source, 0, res1, 0, res1.length);
        System.arraycopy(source, 2, res2, 0, res2.length);


        int res10 = 0;

        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res1.length; i++) {
                    res += res1[i];
                }
                return res;
            }
        };


        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < res2.length; i++) {
                    res += res2[i];
                }
                return res;
            }
        };

        java.util.concurrent.Future<Integer> future1 = executorService.submit(callable1);
        java.util.concurrent.Future<Integer> future2 = executorService.submit(callable2);

        System.out.println(future1.get() + future2.get());
        executorService.shutdown();
    }
}
