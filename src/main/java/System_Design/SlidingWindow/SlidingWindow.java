package System_Design.SlidingWindow;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SlidingWindow {
    private final Queue<Long> window;
    private final int timeWindow;
    private final TimeUnit timeUnit;
    private final int windowCapacity;

    public SlidingWindow(int timeWindow, int windowCapacity, TimeUnit timeUnit) {
        this.timeWindow = timeWindow;
        this.timeUnit = timeUnit;
        this.windowCapacity = windowCapacity;
        window = new ConcurrentLinkedQueue<>();
    }

    public synchronized boolean grantAccess() {
        long currentTimeNS = System.nanoTime();
        removeOutdatedQueueItems(currentTimeNS);
        if (window.size() < windowCapacity) {
            window.offer(currentTimeNS);
            return true;
        }
        return false;
    }

    private void removeOutdatedQueueItems(long currentTime) {
        if (window.isEmpty()) {
            return;
        }

        // проверяю время крайнего в очереди
        long calculatedTime = timeUnit.convert(currentTime - window.peek(), TimeUnit.NANOSECONDS);

        while (calculatedTime >= timeWindow) {
            // если он вышел за рамку окна удаляю его из очереди
            window.poll();

            // очередь пуста можно выходить
            if (window.isEmpty()) {
                break;
            }

            // очередь не пуста
            // переопределяю время следующего элемента для проверки на устаревание
            calculatedTime = timeUnit.convert(currentTime - window.peek(), TimeUnit.NANOSECONDS);
        }
    }
}