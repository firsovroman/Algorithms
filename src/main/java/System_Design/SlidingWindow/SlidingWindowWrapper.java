package System_Design.SlidingWindow;

public class SlidingWindowWrapper {

    SlidingWindowRateLimiter slidingWindowRateLimiter;

    public SlidingWindowWrapper(SlidingWindowRateLimiter slidingWindowRateLimiter) {
        this.slidingWindowRateLimiter = slidingWindowRateLimiter;
    }

    synchronized void tryAcquire(){
        if(slidingWindowRateLimiter.tryAcquire()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }

}
