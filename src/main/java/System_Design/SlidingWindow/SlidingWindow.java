package System_Design.SlidingWindow;


import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class SlidingWindow {
    Queue<Long> slidingWindow;
    int timeWindowInSeconds;
    int bucketCapacity;

    public SlidingWindow(int timeWindowInMinute, int bucketCapacity) {
        this.timeWindowInSeconds = timeWindowInMinute;
        this.bucketCapacity = bucketCapacity;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }

    synchronized public boolean grantAccess() {
        long currentTimeMS = Instant.now().toEpochMilli();
        removeOutdatedQueueItems(currentTimeMS);
        if (slidingWindow.size() < bucketCapacity) {
            slidingWindow.offer(currentTimeMS);
            return true;
        }
        return false;
    }

    private void removeOutdatedQueueItems(long currentTime) {
        if (slidingWindow.isEmpty()) {
            return;
        }

        // проверяю время крайнего в очереди
        long calculatedTime = TimeUnit.MILLISECONDS.toSeconds(currentTime - slidingWindow.peek());

        while (calculatedTime >= timeWindowInSeconds) {
            // если он вышел за рамку окна удаляю его из очереди
            slidingWindow.poll();

            // очередь пуста можно выходить
            if (slidingWindow.isEmpty()) {
                break;
            }

            // очередь не пуста
            // переопределяю время следующего элемента для проверки на устаревание
            calculatedTime = TimeUnit.MILLISECONDS.toSeconds(currentTime - slidingWindow.peek());
        }
    }
}