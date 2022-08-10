package hust.soict.hedspi.aims.database;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db {
    final static private String HOST = "localhost";
    final static private String DBNAME = "aims";
    final static private String USERNAME = "root";
    final static private String PASSWORD = "";
    
    public static Connection getConnectToMySQL(){
        String url = "jdbc:mysql://"+HOST+":3306/"+DBNAME;
        
        try {
            Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Media> getMedia(String product){
        Connection conn = getConnectToMySQL();
        PreparedStatement st = null;
        PreparedStatement st2 = null;
        PreparedStatement st3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        String query = "Select * from media where product = ?";
        String query2 = "Select * from author where id_book = ?";
        String query3 = "Select * from track where id_cd = ?";
        Book book = null;        
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Media> result = new ArrayList<>();
        CompactDisc cd = null;
        try {
            st = conn.prepareCall(query);
            st.setString(1, product);
            rs = st.executeQuery();
            if(product.equals("DVD")){
                while(rs.next()){
                    result.add(new DigitalVideoDisc(rs.getInt("length"), rs.getString("director"),
                        rs.getInt("id"), rs.getString("title"), rs.getString("category"),
                        rs.getFloat("cost")));
                }
            }else if(product.equals("CD")){
                st3 = conn.prepareCall(query3);
                while(rs.next()){
                    cd = new CompactDisc(rs.getString("artist"), 
                            rs.getInt("length"), rs.getString("director"), 
                            rs.getInt("id"), rs.getString("title"), 
                            rs.getString("category"), rs.getFloat("cost"));
                    st3.setInt(1, rs.getInt("id"));
                    rs3 = st3.executeQuery();
                    while(rs3.next()){
                        cd.addTrack(new Track(rs3.getString("title"), 
                                rs3.getInt("length")));
                    }
                    result.add(cd);
                    rs3.close();
                }
                st3.close();
            }else if(product.equals("Book")){
                st2 = conn.prepareCall(query2);                
                while(rs.next()){
                    book = new Book(rs.getInt("id"), rs.getString("title"), 
                            rs.getString("category"), rs.getFloat("cost"));
                    st2.setInt(1, rs.getInt("id"));
                    rs2 = st2.executeQuery();
                    while(rs2.next()){
                        authors.add(rs2.getString("name"));
                    }
                    book.setAuthors(authors);
                    result.add(book);
                    rs2.close();
                }
                st2.close();
                
            }
            st.close();
            rs.close();
            closeConnection(conn);
            
            return result;
        } catch (SQLException ex) {
            closeConnection(conn);
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;   
    }
}
