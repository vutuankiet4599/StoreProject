package hust.soict.hedspi.aims.media;

public class MemoryDaemon implements java.lang.Runnable{
    private long memoryUsed;

    public MemoryDaemon() {
        this.memoryUsed = 0;
    }

    public long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }
    
    
    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used;
        
        while(true){
            used = rt.totalMemory() - rt.freeMemory();
            if(used != memoryUsed){
                System.out.println("\tMemory used = " + used);
            }
        }
    }
    
}
