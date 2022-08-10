
package hust.soict.hedspi.aims.media;

public class Track implements Playable, Comparable<Track>{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public Track(){
        this.length = 0;
        this.title = "";
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    
    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }else{
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
    
    @Override
    public boolean equals(Object tr){
        if(tr != null && tr instanceof Track){
            return (this.length == ((Track) tr).getLength()) && (this.title.equals(((Track) tr).getTitle()));
        }
        return false;
    }

    @Override
    public int compareTo(Track o) {
        return this.title.compareTo(o.getTitle());
    }
}
