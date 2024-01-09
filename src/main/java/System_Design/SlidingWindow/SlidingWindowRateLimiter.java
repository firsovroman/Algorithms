package System_Design.SlidingWindow;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SlidingWindowRateLimiter {
    private final Queue<Long> queueItems;
    private final int timeWindow;
    private final TimeUnit timeUnit;
    private final int windowCapacity;

    public SlidingWindowRateLimiter(int timeWindow, TimeUnit timeUnit, int windowCapacity) {
        this.timeWindow = timeWindow;
        this.timeUnit = timeUnit;
        this.windowCapacity = windowCapacity;
        this.queueItems = new ConcurrentLinkedQueue<>();
    }

    /**
     * Получить разрешение.
     *
     * @return - true, если в окне есть свободные слоты (разрешение получено), и
     *           false, если окно переполнено на текущий момент времени (разрешение отклонено).
     */
    public synchronized boolean acquirePermission() {
        long currentTimeNS = System.nanoTime();
        removeOutdatedQueueItems(currentTimeNS);
        if (queueItems.size() < windowCapacity) {
            queueItems.offer(currentTimeNS);
            return true;
        }
        return false;
    }

    /**
     * Очистить очередь от устаревших элементов вышедших за рамку окна.
     *
     * @param currentTime - текущее время (наносекунды).
     */
    private void removeOutdatedQueueItems(long currentTime) {
        if (queueItems.isEmpty()) {
            return;
        }

        // дельта текущего времени и времени крайнего элемента в очереди
        long delta = timeUnit.convert(currentTime - queueItems.peek(), TimeUnit.NANOSECONDS);

        while (delta >= timeWindow) {
            // если крайний элемент вышел за рамку окна удаляем его из очереди
            queueItems.poll();

            // очередь пуста можно выходить
            if (queueItems.isEmpty()) {
                break;
            }

            // очередь не пуста
            // переопределяем время следующего элемента для проверки на устаревание
            delta = timeUnit.convert(currentTime - queueItems.peek(), TimeUnit.NANOSECONDS);
        }
    }
}