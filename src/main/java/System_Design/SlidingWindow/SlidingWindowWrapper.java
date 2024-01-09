package System_Design.SlidingWindow;

public class SlidingWindowWrapper {

    SlidingWindow slidingWindow;

    public SlidingWindowWrapper(SlidingWindow slidingWindow) {
        this.slidingWindow = slidingWindow;
    }

    synchronized void tryAcquire(){
        if(slidingWindow.grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }

}
