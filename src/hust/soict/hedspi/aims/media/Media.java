package hust.soict.hedspi.aims.media;

abstract public class Media implements Comparable<Media>{
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media(){

    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category) {
        this(title);
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        this(title, category);
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    
    
    public String getTitle() {
        return title;
    }


    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    @Override
    public boolean equals(Object md){
        try {
            return this.id == ((Media) md).getId();
        } catch (NullPointerException | ClassCastException e) {
            e.printStackTrace();
        }
        return false;      
    }
    
    @Override
    public int compareTo(Media o) {
        try {
            return this.title.compareTo(o.getTitle());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return 1;       
    }
}
