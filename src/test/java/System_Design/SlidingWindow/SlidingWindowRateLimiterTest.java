package System_Design.SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.*;

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
    public void testTryAcquireConcurrently() throws InterruptedException {
        // попытки получения разрешения
        Queue<Boolean> permissionAcquisitionAttempts = new ConcurrentLinkedQueue<>();

        // создание SlidingWindowRateLimiter
        int timeWindow = 1; // временное окно в секундах
        int windowCapacity = 5; // емкость окна
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(timeWindow, TimeUnit.SECONDS, windowCapacity);

        // создание нескольких потоков для одновременной попытки получения разрешений
        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);

        // каждый поток будет пытаться получить разрешение
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    // Потоки пытаются получить разрешение
                    boolean acquired = rateLimiter.tryAcquire();
                    permissionAcquisitionAttempts.add(acquired);
                } finally {
                    latch.countDown();
                }
            });
        }

        // ожидание завершения всех потоков
        latch.await();
        executor.shutdown();

        // выводим список попыток для наглядности
        System.out.println(permissionAcquisitionAttempts);

        // считаем выданные разрешения
        long actualSuccessfulAcquires = permissionAcquisitionAttempts.stream().filter(Boolean::booleanValue).count();

        // количество выданных разрешений не превышает размера окна
        Assert.assertEquals(windowCapacity, actualSuccessfulAcquires);
    }
}