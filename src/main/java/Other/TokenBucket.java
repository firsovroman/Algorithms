package Other;

import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private final long capacity; // Емкость токенов в ведре
    private final long refillRate; // Скорость пополнения токенов (в токенах в секунду)
    private final AtomicLong tokens; // Количество доступных токенов
    private Instant lastRefillTime; // Время последнего пополнения токенов

    public TokenBucket(long capacity, long refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTime = Instant.now();
    }

    public synchronized boolean tryConsume(long tokensRequested) {
        refillTokens(); // Пополнение токенов перед попыткой потребления

        if (tokensRequested <= tokens.get()) {
            tokens.getAndAdd(-tokensRequested);
            return true; // Достаточно токенов для потребления
        } else {
            return false; // Недостаточно токенов для потребления
        }
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long timeElapsed = TimeUnit.MILLISECONDS.toSeconds(now.toEpochMilli() - lastRefillTime.toEpochMilli());

        if (timeElapsed > 0) {
            long newTokens = Math.min(capacity, tokens.get() + timeElapsed * refillRate);
            tokens.set(newTokens);
            lastRefillTime = now;
        }
    }

    public static void main(String[] args) {
        // Пример использования
        TokenBucket tokenBucket = new TokenBucket(100, 10); // Емкость = 100, Скорость пополнения = 10 токенов в секунду

        // Попытка потребить 20 токенов
        if (tokenBucket.tryConsume(20)) {
            System.out.println("20 токенов успешно потреблено");
        } else {
            System.out.println("Недостаточно токенов для потребления");
        }
    }
}

