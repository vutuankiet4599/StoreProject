
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String artist) {
        this.artist = artist;
    }

    public CompactDisc(String artist, int length, String director, int id, String title, String category, float cost) {
        super(length, director, id, title, category, cost);
        this.artist = artist;
    }
    
    
    public String getArtist(){
        return artist;
    }
    
    public int getLength(ArrayList<Track> tracks){
        int sumlength = 0;
        for(int i = 0; i < tracks.size(); i++){
            sumlength += tracks.get(i).getLength();
        }
        
        super.length = sumlength;
        return super.length;
    }
    
    public void addTrack(Track track){
        if(this.tracks.contains(tracks)){
            System.out.println("Already exists");
        }else{
            this.tracks.add(track);
        }
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
    
    public void removeTrack(Track track){
        if(!this.tracks.contains(tracks)){
            System.out.println("Track not found!");
        }else{
            this.tracks.remove(track);
        }
    }
    
    @Override
    public void play() throws PlayerException {
        if(this.getLength() <= 0){
            System.err.println("ERROR: CD length is 0");
            throw (new PlayerException());
        }
        
        System.out.println("Playing CD: "+this.getTitle());
        System.out.println("CD Length: "+this.getTitle());
        
        java.util.Iterator iter = tracks.iterator();
        Track nextTrack;
        
        while(iter.hasNext()){
            nextTrack = (Track) iter.next();
            try {
                nextTrack.play();
            } catch (PlayerException e) {
                e.printStackTrace();
            }
        }
    }

    public int compareTo(CompactDisc o) {
        return this.title.compareTo(o.getTitle());
    }
}
