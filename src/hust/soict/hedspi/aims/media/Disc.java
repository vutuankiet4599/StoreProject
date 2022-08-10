
package hust.soict.hedspi.aims.media;


public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(int length, String director) {
        this.length = length;
        this.director = director;
    }

    public Disc(int length, String director, String title) {
        super(title);
        this.length = length;
        this.director = director;
    }

    public Disc(int length, String director, String title, String category) {
        super(title, category);
        this.length = length;
        this.director = director;
    }

    public Disc(int length, String director, String title, String category, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int length, String director, int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    
    public Disc(){
        super();
    }
    
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length >= 0){
            this.length = length;
        }else{
            this.length = 0;
        }  
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
}
