package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.utils.MyDate;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.PlayerException;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class Order {
    public static final int MAX_NUMBERS_ORDERS = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private List<Media> itemOrdered = new ArrayList<Media>();
    private static int nbOrdered = 0;
    private MyDate dateOrdered;

    public MyDate getDateOrdered() {
        return dateOrdered;
    }
    
    public void setDateOrdered(MyDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public static int getNbOrdered() {
        return nbOrdered;
    }
    
    

    public List<Media> getItemOrdered() {
        return this.itemOrdered;
    }
    
    public Order() {
        super();
        dateOrdered = new MyDate();
    }
    
    public void addMedia(Media media) throws PlayerException{
        if(nbOrdered < MAX_NUMBERS_ORDERS){
            if(!this.itemOrdered.contains(media)){
                this.itemOrdered.add(media);
                nbOrdered++;
            }
        }else{
            throw new PlayerException("ERROR: ORDERED NUMBER IS FULL!");
        }
        
    }
    
    public void removeMedia(Media media){
        if(this.itemOrdered.contains(media)){
            this.itemOrdered.remove(media);
            nbOrdered--;
        }
    }
    
    public float totalCost(){
        float total = 0.0f;
        total = itemOrdered.stream().map((ma) -> ma.getCost()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }
    
    public void printOrder(){
        System.out.println("***********************Order***********************");
        System.out.println("Date: "+dateOrdered.date());
        System.out.println("Ordered Items:");
        int i = 0;
        itemOrdered.forEach((Item) -> {
            System.out.println((i+1)+"."+" DVD - "+Item.getTitle()+
                    " - "+Item.getCategory()+" - "+Item.getCost()+"$");
        });

        System.out.println("Total cost: "+this.totalCost());
        System.out.println("***********************Order***********************");
    }
    
    public Media getALuckyItem(){
        Media md = null;
        float total = totalCost();
        if(nbOrdered > 5 || total > 1000){
            Random rd = new Random();     
            int chance = 0;
            do{   
                int luckyNumber = rd.nextInt((this.itemOrdered.size()));
                float price = total/2;
                Media item = this.itemOrdered.get(luckyNumber);
                if(item.getCost() <= price){
                    md = item;
                    md.setCost(0);
                    break;
                }
                chance++;
            }while(chance < 10);
        }
        return md;
    }
}
