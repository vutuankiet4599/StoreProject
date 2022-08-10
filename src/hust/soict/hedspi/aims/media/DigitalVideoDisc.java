package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    
    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(int length, String director, int id, String title, String category, float cost) {
        super(length, director, id, title, category, cost);
    }

        
    public boolean search(String title){
        String sTitle[] = title.toLowerCase().split(" ");
        boolean result = true;
        for(String s : sTitle){
            if(!this.title.toLowerCase().contains(s)){
                result = false;
                break;
            }
        }
        return result;
    }

    public void printInfo(){
        System.out.println("-----DVD Infomation-----");
        System.out.println("ID: "+this.getId());
        System.out.println("Title: "+this.title);
        System.out.println("Category: "+this.category);
        System.out.println("Directory: "+this.director);
        System.out.println("Length: "+this.length);
        System.out.println("Cost: "+this.cost);
    }
    
    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0){
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }else{
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        
    }

    public int compareTo(DigitalVideoDisc obj) {
        return this.title.compareTo(obj.title);
        
//        if(this.getLength() < (obj).getLength()){
//            return -1;
//        }else if(this.getLength() == ( obj).getLength()){
//            return 0;
//        }else{
//            return 1;
//        }
    }
    
}
