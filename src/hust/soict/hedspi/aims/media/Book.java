package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    private String listAuthors;
    private List<String> contentTokens;
    private Map<String, Integer> wordFrequency;

    public Book() {
        super();
    }
    
    public Book(String title){
        super(title);
    }
    
    public Book(String title, String category){
        super(title, category);
    }
    
    public Book(String title, String category, List<String> suthors){
        super(title, category);
        this.authors = authors;
    }
    
    public Book(String title, String category, float cost, List<String> authors){
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public List<String> getAuthors() {
        return authors;
    }
    
    public void AuthorsToString(){
        String result = "";
        for (String author : authors) {
            result += author + ", ";
        }
        this.listAuthors = result;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
    }
    
    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
        }
    }

    public int compareTo(Book o) {
        return this.title.compareTo(o.getTitle());
    }
    
    public void processContent(){
        String[] contents = this.title.split(" ");
        Arrays.sort(contents);
        for(String str : contents){
            if(!this.contentTokens.contains(str))
                this.contentTokens.add(str);
        }
        
        for(String str : contents){
            if(!this.wordFrequency.containsKey(str)){
                this.wordFrequency.put(str, 1);
            }else{
                this.wordFrequency.replace(str, this.wordFrequency.get(str) + 1);
            }
        }
    }
}
