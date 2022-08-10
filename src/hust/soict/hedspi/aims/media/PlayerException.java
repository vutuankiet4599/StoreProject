package hust.soict.hedspi.aims.media;

public class PlayerException extends Exception{
    public PlayerException(){
        super();
    }
    
    public PlayerException(String str){
        super(str);
    }
    
    public PlayerException(String str, Throwable thr){
        super(str, thr);
    }
    
    public PlayerException(Throwable thr){
        super(thr);
    }
}
