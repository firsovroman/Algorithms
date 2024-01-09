package System_Design.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SlidingWindowRateLimiterTest {

    @Test
    public void testGrantAccess() throws InterruptedException {

        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(60, TimeUnit.SECONDS, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(slidingWindowRateLimiter.tryAcquire() + " - " + Instant.now());
            Thread.sleep(15_000);
        }

        Thread.sleep(5_000);
        System.out.println("=============");


        // за 20 секунд окно успевает сместится и освободить 2 элемента из 5
        Assert.assertTrue(slidingWindowRateLimiter.tryAcquire());
        Assert.assertTrue(slidingWindowRateLimiter.tryAcquire());

        // а для третьего запроса элемента нет
        Assert.assertFalse(slidingWindowRateLimiter.tryAcquire());

    }


    @Test
    public void concurrencyTestGrantAccess() {

        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(1, TimeUnit.SECONDS, 5);
        SlidingWindowWrapper wrapper = new SlidingWindowWrapper(slidingWindowRateLimiter);

        ExecutorService executors = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            executors.execute(wrapper::tryAcquire);
        }
        executors.shutdown();

    }
}