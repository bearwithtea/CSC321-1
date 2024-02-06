/**
 * Class that models a simple stopwatch
 * @author Dave Reed
 * @version 12/28/23
 */
public class StopWatch {
    private long lastStart;
    private long lastElapsed;
    private long totalElapsed;
    
    /**
     * Constructs a stopwatch.
     */
    public StopWatch() {
        this.reset();
    }
    
    /**
     * Starts the timer on the stopwatch.
     */
    public void start() {
        this.lastStart = System.currentTimeMillis();
    }
    
    /**
     * Stops the timer on the stopwatch.
     */
    public void stop() {
        long stopTime = System.currentTimeMillis();
        if (this.lastStart != -1) {
            this.lastElapsed = stopTime - this.lastStart;
            this.totalElapsed += this.lastElapsed;
            this.lastStart = -1;
        }
    }
    
    /**
     * Reports the time between the last start() & stop().
     * @return the elapsed time in milliseconds
     */
    public long getElapsedTime() {
        return this.lastElapsed;
    }
        
    /**
     * Reports the total elapsed time of all stopwatch timings.
     * @return the total elapsed time in milliseconds
     */
    public long getTotalElapsedTime() {
        return this.totalElapsed;
    }   
    
    /**
     * Resets the stopwatch (setting the elapsed time total back to 0).
     */
    public void reset() {
        this.lastStart = -1;
        this.lastElapsed = 0;
        this.totalElapsed = 0;
    }
}