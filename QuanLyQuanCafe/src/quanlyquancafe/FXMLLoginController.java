/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import quanlyquancafe.pojo.Account;

/**
 *
 * @author nguyenthanhtu
 */
public class FXMLLoginController implements Initializable {
    @FXML
    private JFXTextField txtAccount;
    @FXML
    private Button btSubmit;
    @FXML
    private JFXPasswordField txtPassword;
    //Ham dang nhap
    private void Login(Event evt){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try{
            trans = session.beginTransaction();
            //Chu y cat chuoi
            Query q = session.createQuery("FROM Account WHERE idAccount=:filter");
            //Chu y cat chuoi
            q.setParameter("filter", txtAccount.getText());
            List accounts = q.list();
            Iterator iterator = accounts.iterator();
            while(iterator.hasNext()){
                Account a = (Account)iterator.next();
                if(txtAccount.getText().equals(a.getIdAccount().trim()) && txtPassword.getText().equals(a.getPassword().trim())){
                    //Xu ly chuyen Scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/FXMLHome.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage window = (Stage)((Node)evt.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
                    window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("LOGIN");
                    alert.setHeaderText("Notifications");
                    alert.setContentText("Login fail!");
                    alert.show();
                }
            }
        }
        catch(Exception ex){
            if(trans != null)
                trans.rollback();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("LOGIN");
                alert.setHeaderText("Notifications");
                alert.setContentText("Login fail!");
                alert.show();
        }
        finally{
            session.close();
        }
    }
    //Xu ly dang nhap
    @FXML
    private void submitHandler(ActionEvent event) { 
        Login(event);
    }
    //Xu ly enter dang nhap
    @FXML 
    public void enterToLogin(KeyEvent e) {
        if(e.getCode().equals(KeyCode.ENTER)) {
            Login(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
