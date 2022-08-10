
package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class TestPassingParamater {

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc();
        DigitalVideoDisc dvd2 = new DigitalVideoDisc();
        
        dvd1.setTitle("Jungle");
        dvd2.setTitle("Cinderella");
        
        swap(dvd1, dvd2);
        System.out.println("jungle dvd title: "+dvd1.getTitle());
        System.out.println("cinderella dvd title: "+dvd2.getTitle());
        
        changeTitle(dvd1, dvd2.getTitle());
        System.out.println("jungle dvd title: "+dvd1.getTitle());
    }
    
    public static void main(String[] args, int argv){
        
    }
    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    
    public static void changeTitle(DigitalVideoDisc disc, String title){
        String oldTitle = disc.getTitle();
        disc.setTitle(title);
        disc = new DigitalVideoDisc();
        disc.setTitle(oldTitle);
    }
}
