package system_design.sliding_window;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * RateLimiter основанный на алгоритме Sliding Window (скользящее окно).
 *
 */
public class SlidingWindowRateLimiter {
    private final Queue<Long> grantedPermissionHistory;
    private final int timeWindow;
    private final TimeUnit timeUnit;
    private final int windowCapacity;

    public SlidingWindowRateLimiter(int timeWindow, TimeUnit timeUnit, int windowCapacity) {
        this.timeWindow = timeWindow;
        this.timeUnit = timeUnit;
        this.windowCapacity = windowCapacity;
        this.grantedPermissionHistory = new LinkedList<>();
    }

    /**
     * Пытается получить разрешение на текущий момент времени.
     *
     * @return true, если доступны свободные слоты разрешений; в противном случае - false.
     */
    public synchronized boolean tryAcquire() {
        long currentTimeNS = System.nanoTime();
        removeOutdatedPermissions(currentTimeNS);
        if (grantedPermissionHistory.size() < windowCapacity) {
            grantedPermissionHistory.add(currentTimeNS);
            return true;
        }
        return false;
    }

    /**
     * Очистить очередь от устаревших разрешений вышедших (по времени) за рамку окна.
     *
     * @param currentTimeNS - текущее время.
     */
    private void removeOutdatedPermissions(long currentTimeNS) {
        if (grantedPermissionHistory.isEmpty()) {
            return;
        }

        // рассчитываем временную разницу между текущим временем и временем выдачи самого старого разрешения в очереди
        long delta = timeUnit.convert(currentTimeNS - grantedPermissionHistory.peek(), TimeUnit.NANOSECONDS);

        while (delta >= timeWindow) {
            // если самое старое разрешение вышло за рамку окна, то удаляем его из очереди выданных разрешений
            grantedPermissionHistory.poll();

            // очередь пуста можно выходить
            if (grantedPermissionHistory.isEmpty()) {
                break;
            }

            // очередь не пуста
            // переопределяем дельту используя следующее (пo cтapшинcтвy) время выданного разрешения
            delta = timeUnit.convert(currentTimeNS - grantedPermissionHistory.peek(), TimeUnit.NANOSECONDS);
        }
    }
}