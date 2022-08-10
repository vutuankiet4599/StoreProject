package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.database.db;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.PlayerException;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.users.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Admin
 */
public class ShopController implements Initializable {
    private int countFree;
    
    @FXML private TableView<DigitalVideoDisc> tableDVD;
    @FXML private TableColumn<DigitalVideoDisc, Integer> dvdId;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdTitle;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdCategory;
    @FXML private TableColumn<DigitalVideoDisc, String> dvdDirectory;
    @FXML private TableColumn<DigitalVideoDisc, Float> dvdCost;
    @FXML private TableColumn<DigitalVideoDisc, Integer> dvdLength;
    
    @FXML private TableView<Book> tableBook;
    @FXML private TableColumn<Book, Integer> bookId;
    @FXML private TableColumn<Book, String> bookTitle;
    @FXML private TableColumn<Book, String> bookCategory;
    @FXML private TableColumn<Book, Float> bookCost;
    @FXML private TableColumn<Book, ArrayList<String>> bookAuthors;
    
    @FXML private TableView<CompactDisc> tableCD;
    @FXML private TableColumn<CompactDisc, Integer> cdId;
    @FXML private TableColumn<CompactDisc, String> cdTitle;
    @FXML private TableColumn<CompactDisc, String> cdCategory;
    @FXML private TableColumn<CompactDisc, String> cdArtist;
    @FXML private TableColumn<CompactDisc, Float> cdCost;
    @FXML private TableColumn<CompactDisc, Integer> cdLength;
    
    private static Order order = null;
    
    @FXML private TableView<Media> tableOrder;
    @FXML private TableColumn<Media, Integer> orderId;
    @FXML private TableColumn<Media, String> orderTitle;
    @FXML private TableColumn<Media, String> orderCategory;
    @FXML private TableColumn<Media, Float> orderCost;
    
    @FXML private TableView<Track> tableTrack;
    @FXML private TableColumn<Track, String> trackTitle;
    @FXML private TableColumn<Track, Integer> trackLength;
    
    @FXML private TextField txtCard;
    @FXML private Label errCard;
    
    private Users user;
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        trackTitle.setCellValueFactory(new PropertyValueFactory<Track, String>("title"));
        trackLength.setCellValueFactory(new PropertyValueFactory<Track, Integer>("length"));
        
        dvdId.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Integer>("id"));
        dvdTitle.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("title"));
        dvdCategory.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("category"));
        dvdDirectory.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, String>("director"));
        dvdCost.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Float>("cost"));
        dvdLength.setCellValueFactory(new PropertyValueFactory<DigitalVideoDisc, Integer>("length"));
        tableDVD.setItems(getDVD());
        
        bookId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        bookCategory.setCellValueFactory(new PropertyValueFactory<Book, String>("category"));
        bookCost.setCellValueFactory(new PropertyValueFactory<Book, Float>("cost"));
        bookAuthors.setCellValueFactory(new PropertyValueFactory<Book, ArrayList<String>>("authors"));
        tableBook.setItems(getBook());
        
        cdId.setCellValueFactory(new PropertyValueFactory<CompactDisc, Integer>("id"));
        cdTitle.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("title"));
        cdCategory.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("category"));
        cdArtist.setCellValueFactory(new PropertyValueFactory<CompactDisc, String>("artist"));
        cdCost.setCellValueFactory(new PropertyValueFactory<CompactDisc, Float>("cost"));
        cdLength.setCellValueFactory(new PropertyValueFactory<CompactDisc, Integer>("length"));
        tableCD.setItems(getCD());
        
        orderId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        orderTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        orderCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        orderCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tableOrder.setItems(getOrder());        
    }    
    
    public void getUser(Users user){
        this.user = user;
    }
    
    public ObservableList<DigitalVideoDisc> getDVD(){
        ObservableList<DigitalVideoDisc> dvd = FXCollections.observableArrayList();
        ArrayList<Media> lst = db.getMedia("DVD");
        DigitalVideoDisc data;
        for(Media media : lst){
            data = (DigitalVideoDisc)media;
            dvd.add(data);
        }
        return dvd;
    }
    
    public ObservableList<Book> getBook(){
        ObservableList<Book> book = FXCollections.observableArrayList();
        ArrayList<Media> lst = db.getMedia("Book");
        Book data;
        for(Media media : lst){
            data = (Book)media;
            book.add(data);
        }
        return book;
    }
    
    public ObservableList<CompactDisc> getCD() {
        ObservableList<CompactDisc> CD = FXCollections.observableArrayList();
        ArrayList<Media> lst = db.getMedia("CD");
        CompactDisc data;
        for(Media media : lst){
            data = (CompactDisc)media;
            CD.add(data);
        }
        return CD;
    }
    
    public ObservableList<Media> getOrder(){
        ObservableList<Media> md = FXCollections.observableArrayList();
        if(order != null){
            if(order.getItemOrdered() != null){
                order.getItemOrdered().forEach((Items) -> {
                    md.add(Items);
                });
            }
        }
        return md;   
    }
    
    public void createOrder(){
        try {
            order = new Order();
            countFree = 0;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Thông báo");
            alert.setContentText("Tạo Order mới thành công");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Thông báo");
            alert.setContentText("Tạo Order mới thất bại");
            alert.showAndWait();
        }
    }
    
    public DigitalVideoDisc getDataDVD(){
        DigitalVideoDisc dvd = tableDVD.getSelectionModel().getSelectedItem();
        return dvd;
    }
    
    public Book getDataBook(){
        Book book = tableBook.getSelectionModel().getSelectedItem();
        return book;
    }
    
    public CompactDisc getDataCD(){
        CompactDisc cd = tableCD.getSelectionModel().getSelectedItem();
        return cd;
    }
    
    public Media getDataOrder(){
        Media md = tableOrder.getSelectionModel().getSelectedItem();
        return md;
    }
    
    public void addDVD() throws PlayerException{
        DigitalVideoDisc dvd = getDataDVD();
        if(order != null){
            if(dvd != null){
                order.addMedia(dvd);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("MỜI TẠO GIỎ HÀNG TRƯỚC");
            alert.showAndWait();
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    public void addBook() throws PlayerException{
        Book book = getDataBook();
        if(order != null){
            if(book != null){
                order.addMedia(book);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("MỜI TẠO GIỎ HÀNG TRƯỚC");
            alert.showAndWait();
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    public void addCD() throws PlayerException{
        CompactDisc cd = getDataCD();
        if(order != null){
            if(cd != null){
                order.addMedia(cd);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU MUST CHOOSE ONE!");
            }    
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("MỜI TẠO GIỎ HÀNG TRƯỚC");
            alert.showAndWait();
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    public void deleteFromOrder() throws PlayerException{
        if(order != null){
            Media md = getDataOrder();
            if(md != null){
                order.removeMedia(md);
                tableOrder.setItems(getOrder());
            }else{
                throw new PlayerException("YOU STILL NOT CHOOSE THE ITEM");
            }
        }else{
            throw new PlayerException("ORDER IS NOT CREATED!");
        }
    }
    
    public void getLuckyItem() throws PlayerException{
        if(order != null){
            if(countFree == 0){
                if(order.totalCost() > 1000.0f && Order.getNbOrdered() >= 5){
                    order.getALuckyItem();
                    countFree = 1;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Thông báo");
                    alert.setContentText("Nhận thành công");
                    alert.showAndWait();
                    tableOrder.setItems(getOrder());
                }else{
                    throw new PlayerException("STILL UNQUALIFIED");
                }                
            }else{
                throw new PlayerException("ONLY ONE PRODUCT IS GIVEN");
            }    
        }else{
            throw new PlayerException("ORDER IS NOT CREATED");
        }
    }
    
    public void playCD() throws PlayerException{
        CompactDisc cd = getDataCD();
        int check = 0;
        if(cd != null){
            ObservableList<Track> track = FXCollections.observableArrayList();
            if(cd.getTracks() != null){
                if(cd.getLength() > 0){
                    cd.getTracks().forEach((Item) -> {
                        if(Item.getLength() > 0){
                            track.add(Item);
                        }
                    });
                    tableTrack.setItems(track);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Track của CD được phát tại Play Tracks");
                    alert.showAndWait();
                }else{
                    throw new PlayerException("CD LENGTH IS NON-POSITIVE!");
                }
                
            }else{
                throw new PlayerException("TRACK IN CD IS NULL!");
            }
        }else{
            throw new PlayerException("YOU NEED TO CHOOSE ONE CD!");
        }
    }
    
    public void playDVD() throws PlayerException{
        DigitalVideoDisc dvd = getDataDVD();
        if(dvd != null){
            if(dvd.getLength() > 0){
                String title = "Title: " + dvd.getTitle();
                String length = "Length: " + dvd.getLength();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("DVD đang chạy");
                alert.setContentText(title+"\n"+length);
                alert.showAndWait();
            }else{
                throw new PlayerException("DVD LENGTH IS NON-POSITIVE");
            }
            
        }else{
            throw new PlayerException("YOU NEED TO CHOOSE ONE DVD!");
        }
    }
    
    public void resetPlay(){
        tableTrack.getItems().clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Reset bảng thành công");
        alert.showAndWait();
    }
    
    public void postOrder(){
        Connection conn = db.getConnectToMySQL();
        String query = "Update users set money = ? where username = ?";
        String query2 = "Insert into `orders`(`customer_name`, `id_media`, `cost`, `day`)"
                + "values (?, ?, ?, ?)";
        PreparedStatement st = null;
        PreparedStatement st2 = null;
        float total = 0;
        if(order.getItemOrdered() != null){
            for(Media md : order.getItemOrdered()){
                total += md.getCost();                
            }
            if(total <= user.getMoney()){
                user.setMoney(user.getMoney()-total);
                try {
                    st = conn.prepareCall(query);
                    st.setFloat(1, user.getMoney());
                    st.setString(2, user.getUsername());
                    st.executeUpdate();
                    st.close();
                    st2 = conn.prepareCall(query2);                    
                    for(Media md : order.getItemOrdered()){
                        st2.setString(1, user.getUsername());
                        st2.setInt(2, md.getId());
                        st2.setFloat(3, md.getCost());
                        st2.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                        st2.executeUpdate();
                    }
                    st2.close();
                    db.closeConnection(conn);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("SỐ TIỀN CÒN LẠI: "+user.getMoney());
                    alert.showAndWait();
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("MUA HÀNG THẤT BẠI");
                    alert.showAndWait();
                    Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("KHÔNG ĐỦ TIỀN");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("GIỎ HÀNG RỖNG");
            alert.showAndWait();
        }
        
    }
    
    public void recharge(){
        Connection conn = db.getConnectToMySQL();
        String query = "Update users set money = ? where username = ?";
        String query2 = "Select * from card where card = ?";
        String query3 = "Update card set isused = 1 where card = ?";
        String card = txtCard.getText();
        PreparedStatement st = null;
        PreparedStatement st2 = null;
        PreparedStatement st3 = null;
        ResultSet rs = null;
        float money;
        try {
            st2 = conn.prepareCall(query2);
            st2.setString(1, card);
            rs = st2.executeQuery();
            if(!rs.next()){
                errCard.setText("*Mã thẻ không đúng");
            }else{
                if(rs.getBoolean("isused")){
                    errCard.setText("*Thẻ đã được sử dụng");
                }else{
                    st = conn.prepareCall(query);
                    money = user.getMoney() + rs.getFloat("money");
                    user.setMoney(money);
                    st.setFloat(1, money);
                    st.setString(2, user.getUsername());
                    st.execute();
                    st3 = conn.prepareCall(query3);
                    st3.setString(1, card);
                    st3.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("NẠP THÀNH CÔNG. SỐ TIỀN CÒN DƯ: "+user.getMoney());
                    alert.showAndWait();
                    st.close();
                }
            }
            st2.close();
            rs.close();
            db.closeConnection(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
