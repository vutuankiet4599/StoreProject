package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.database.db;
import hust.soict.hedspi.aims.users.Users;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController implements Initializable {
    
    @FXML private TextField txtTaikhoan;
    @FXML private PasswordField txtMatkhau;
    @FXML private Label errTaikhoan;
    @FXML private Label errMatkhau;
    
    @FXML private Label invalidMatkhau;
    @FXML private Label invalidTaikhoan;
    @FXML private Label invalidHoten;
    
    @FXML private TextField registerTaikhoan;
    @FXML private TextField registerMatkhau;
    @FXML private TextField registerHoten;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML public void postLogin(ActionEvent event) throws IOException{
        errMatkhau.setText("");
        errTaikhoan.setText("");
        String username = txtTaikhoan.getText();
        String password = txtMatkhau.getText();
        String sqlpass = "";
        String query = "SELECT * FROM users WHERE `username` = ?";
        Users user;
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;        
        
        try {
            conn = db.getConnectToMySQL();
            st = conn.prepareCall(query);
            st.setString(1, username);
            rs = st.executeQuery();
            if(!rs.next()){
                errTaikhoan.setText("*Sai Tài khoản");
            }else{
                sqlpass = rs.getString("password");
                if(!sqlpass.equals(Users.encryptPassword(password))){
                    errMatkhau.setText("*Sai mật khẩu");
                }else{
                    user = new Users(username, password, rs.getString("name"), rs.getFloat("money"));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Đăng nhập thành công");
                    alert.showAndWait();
                    db.closeConnection(conn);
                    st.close();
                    rs.close();
                    getShop(event, user);
                }
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Đăng nhập thất bại");
            alert.showAndWait();
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getShop(ActionEvent event, Users user) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("\\FXMLShop.fxml"));
        Parent root = loader.load(); 
        ShopController controller = loader.getController();
        controller.getUser(user);
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void getRegister(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("\\FXMLRegister.fxml"));
        Parent root = loader.load(); 
        
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void getLogin(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("\\FXMLLogin.fxml"));
        Parent root = loader.load(); 
        
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void postRegister(ActionEvent event) throws IOException {
        invalidHoten.setText("");
        invalidMatkhau.setText("");
        invalidTaikhoan.setText("");
        String username = registerTaikhoan.getText();
        String password = registerMatkhau.getText();
        String name = registerHoten.getText();
        String query = "";
        
        
        if(username.length() < 5){
            invalidTaikhoan.setText("*Tên tài khoản quá ngắn");
        }else if(password.length() < 5) {
            invalidMatkhau.setText("*Mật khẩu quá ngắn");
        }else if(name.length() < 5){
            invalidTaikhoan.setText("*Tên quá ngắn");
        }else{            
            try {
                Connection conn;
                conn = db.getConnectToMySQL();
                conn.setAutoCommit(false);
                PreparedStatement st = null;
                query = "INSERT INTO users (`username`, `password`, `name`, `money`)"
                    + " VALUES(?, ?, ?, ?)";
                st = conn.prepareCall(query);
                st.setString(1, username);
                st.setString(2, Users.encryptPassword(password));
                st.setString(3, name);
                st.setInt(4, 2000);
                st.executeUpdate();
                conn.commit();
                
                st.close();
                db.closeConnection(conn);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Đăng ký thành công");
                alert.showAndWait();
                getLogin(event);
                
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Đăng ký thất bại");
                alert.showAndWait();
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
}
