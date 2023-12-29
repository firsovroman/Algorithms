package System_Design;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private final long capacity; // емкость токенов в ведре
    private final long refillRate; // скорость пополнения токенов (в токенах в минуту)
    private final AtomicLong tokens; // количество доступных токенов
    private Instant lastRefillTime; // время последнего пополнения токенов

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTime = Instant.now();
    }

    public synchronized boolean tryAcquire() {
        refillTokens(); // пополнение токенов перед попыткой потребления

        if (tokens.get() >= 1) {
            tokens.getAndAdd(-1);
            return true; // достаточно токенов для потребления
        } else {
            return false; // недостаточно токенов для потребления
        }
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long timeElapsed = TimeUnit.MILLISECONDS.toMinutes(now.toEpochMilli() - lastRefillTime.toEpochMilli());

        // определяем пришло ли время наполнить ведро токенов
        if (timeElapsed > 0) {
            // текущее количество токенов плюс то что должно было быть восполнено за время которое прошло
            long newTokens = Math.min(capacity, tokens.get() + timeElapsed * refillRate);
            tokens.set(newTokens);
            lastRefillTime = now;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // пример использования
        TokenBucket tokenBucket = new TokenBucket(5, 5); // Емкость = 5, Скорость пополнения = 1 токенов в минуту


        for (int i = 0; i < 6; i++) {
            System.out.println(tokenBucket.tryAcquire());
        }
        System.out.println("===========");
        Thread.sleep(10000);

        for (int i = 0; i < 6; i++) {
            System.out.println(tokenBucket.tryAcquire());
        }

    }
}

