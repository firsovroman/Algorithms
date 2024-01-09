package System_Design.SlidingWindow;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class SlidingWindowRateLimiterTest {

    @Test
    public void testSlidingWindowRateLimiter() throws InterruptedException {
        // создаем объект ограничитель с временным окном 1 секунда и вместимостью окна 2 слота
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(1, TimeUnit.SECONDS, 2);

        // получаем первый доступ
        assertTrue(rateLimiter.tryAcquire());

        // ждем половину секунды и получаем второй доступ
        Thread.sleep(500);
        assertTrue(rateLimiter.tryAcquire());

        // проверяем что получить доступ после заполнения окна не получится
        assertFalse(rateLimiter.tryAcquire());

        // ждем 501 миллисекунду, (этого достаточно чтобы освободился первый слот, но не достаточно чтобы освободился второй)
        Thread.sleep(501);
        assertTrue(rateLimiter.tryAcquire());
        assertFalse(rateLimiter.tryAcquire());

        // Проверяем, что история выданных разрешений очищается после выхода за пределы окна
        Thread.sleep(1500);
        assertTrue(rateLimiter.tryAcquire());
        assertTrue(rateLimiter.tryAcquire());
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
                    boolean acquired = rateLimiter.tryAcquire();
                    // результаты сохраняются
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
        assertEquals(windowCapacity, actualSuccessfulAcquires);
    }
}