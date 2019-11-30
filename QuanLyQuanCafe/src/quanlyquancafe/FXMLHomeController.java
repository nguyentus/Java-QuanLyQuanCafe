package quanlyquancafe;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import quanlyquancafe.pojo.Account;
import quanlyquancafe.pojo.Drink;
import quanlyquancafe.pojo.DrinkCategory;

public class FXMLHomeController implements Initializable {
    @FXML private Pane pDrinkCategory;
    @FXML private Button btCategory;
    @FXML private Button btDrinkMenu;
    @FXML private Label lbDisplayName; 
    @FXML private TableView tbDrinkCategory;
    @FXML private TableColumn colIDDrinkCategory;
    @FXML private TableColumn colDrinkCategoryName;
    @FXML private JFXTextField txtSearch;
    @FXML private JFXTextField txtIDDrinkCategory;
    @FXML private JFXTextField txtNameDrinkCategory;
    @FXML private JFXButton btAddDrinkCategory;
    @FXML private JFXButton btUpdateDrinkCategory;
    @FXML private JFXButton btDeleteDrinkCategory;
    @FXML private Pane pDrinkMenu;
    @FXML private TableView tbDrink;
    @FXML private JFXTextField txtDrinkID;
    @FXML private JFXTextField txtNameDrink;
    @FXML private JFXTextField txtPriceDrink;
    @FXML private JFXComboBox<DrinkCategory> cbCategoryName;
    @FXML private TableColumn colIDDrink;
    @FXML private TableColumn colNameDrink;
    @FXML private TableColumn colPriceDrink;
    @FXML private TableColumn colDrinkCategory;
    @FXML private JFXButton btAddDrink;
    @FXML private JFXButton btUpdateDrink;
    @FXML private JFXButton btDeleteDrink;
    //////////////////////////////////////////////////////DRINK CATEGORY///////////////////////////////////////////////////////
    
    //Chuyen Scene Category
    @FXML
    private void sceneCategory(ActionEvent evt) throws IOException { 
        this.pDrinkCategory.setVisible(true);
        this.pDrinkMenu.setVisible(false);
    }
    
    
    //Xu ly su kien click tren mot dong
    private void clickRowDrinkCategory(){
        this.tbDrinkCategory.setRowFactory(tb -> {
            TableRow<DrinkCategory> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if(e.getClickCount() == 1){
                    DrinkCategory dc = row.getItem();
                    txtIDDrinkCategory.setText(String.valueOf(dc.getIdDrinkCategory()));
                    txtNameDrinkCategory.setText(dc.getNameDrinkCategory());
                }
            });
            return row;
        });
    }
    //Lay danh sach DrinkCategory
    private ObservableList<DrinkCategory> getDrinkCategories(String kw){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(DrinkCategory.class);
    //Xu ly tim kiem
        if(kw != null && !kw.equals("")){
            kw = String.format("%%%s%%", kw);
            cr.add(Restrictions.or(Restrictions.ilike("nameDrinkCategory", kw)));
        }
        //Lấy danh sách tất cả các DrinkCategory
        List<DrinkCategory> drinkCategories = null;
        drinkCategories = cr.list();
        //Thêm DrinkCategory vào ComboBox 
        this.cbCategoryName.getItems().addAll(drinkCategories);
        session.close();
        return FXCollections.observableArrayList(drinkCategories);
    }
    
    //Thêm Dữ Liêu
    @FXML
    private void addDrinkCategoryHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        DrinkCategory drinkCategory = new DrinkCategory(Integer.parseInt(this.txtIDDrinkCategory.getText()), this.txtNameDrinkCategory.getText());
        Transaction trans = null;
        Query q = session.createQuery("FROM DrinkCategory");
        try{
            trans = session.beginTransaction();
            session.save(drinkCategory);
            trans.commit();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Insert Dink Category Successful!");
            alert.show();
            this.reloadTable("");
        }
        catch(Exception ex){
            if(trans != null)
                trans.rollback();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Insert Dink Category Fail!");
            alert.show();
        }
        finally{
            session.close();
        }
    }
    //Cập Nhật Dữ Liệu
    @FXML
    private void updateDrinkCategoryHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            if(!txtIDDrinkCategory.getText().isEmpty()){
               DrinkCategory dc = (DrinkCategory) session.get(DrinkCategory.class, Integer.parseInt(txtIDDrinkCategory.getText()));
               dc.setIdDrinkCategory(Integer.parseInt(txtIDDrinkCategory.getText()));
               dc.setNameDrinkCategory(txtNameDrinkCategory.getText());
               Transaction trans = session.beginTransaction();
               session.update(dc);
               trans.commit();
               this.reloadTable("");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Update Dink Category Successful!");
               alert.show();   
            }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Update Dink Category Fail!");
            alert.show();   
        }
        finally{
            session.close();
        }
    }
    //Xoá dữ liệu
    @FXML
    private void deleteDrinkCategoryHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            if(!txtIDDrinkCategory.getText().isEmpty()){      
               DrinkCategory dc = (DrinkCategory) session.get(DrinkCategory.class, Integer.parseInt(txtIDDrinkCategory.getText()));
               dc.setIdDrinkCategory(Integer.parseInt(txtIDDrinkCategory.getText()));
               Transaction trans = session.beginTransaction();
               session.delete(dc);
               trans.commit();
               this.reloadTable("");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Delete Dink Category Successful!");
               alert.show();   
        }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Delete Dink Category Fail!");
            alert.show();   
        }
        finally{
            session.close();
        }
    }    
    
    /////////////////////////////////////////////////////DRINK MENU////////////////////////////////////////////////////
    
    //Chuyen Scene Drink
    @FXML
    private void sceneDrink(ActionEvent evt) throws IOException { 
        this.pDrinkMenu.setVisible(true);
        this.pDrinkCategory.setVisible(false);
    }
    
    //Load lai table Drink
//    private void reloadTableDrink(String kw){
//        this.tbDrink.getItems().clear();
//        this.tbDrink.setItems(this.getDrinkCategories(kw));
//    }
    
    //Xu ly su kien click tren mot dong
    private void clickRowDrink(){
        this.tbDrink.setRowFactory(tb -> {
            TableRow<Drink> row = new TableRow<>();
            row.setOnMouseClicked(e -> {
                if(e.getClickCount() == 1){
                    Drink d = row.getItem();
                    txtDrinkID.setText(String.valueOf(d.getIdDrink()));
                    txtNameDrink.setText(d.getNameDrink());
                    txtPriceDrink.setText(String.valueOf(d.getPriceDrink()));
                    cbCategoryName.setValue(d.getDrinkCategory());
                }
            });
            return row;
        });
    }
    
    //Lay danh sach DrinkCategory
    private ObservableList<Drink> getDrink(String kw){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Drink.class);
        //Xu ly tim kiem
        if(kw != null && !kw.equals("")){
            kw = String.format("%%%s%%", kw);
            cr.add(Restrictions.or(Restrictions.ilike("nameDrink", kw)));
        }
        List<Drink> drink = cr.list();
        session.close();
        return FXCollections.observableArrayList(drink);
    }
    
    //Thêm Dữ Liêu
    @FXML
    private void addDrinkHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Drink drink = new Drink();
        drink.setIdDrink(Integer.parseInt(this.txtDrinkID.getText()));
        drink.setNameDrink(this.txtNameDrink.getText());
        drink.setPriceDrink(Double.parseDouble(this.txtPriceDrink.getText()));
        
        drink.setDrinkCategory((DrinkCategory) this.cbCategoryName.getSelectionModel().getSelectedItem());
        Transaction trans = null;
        Query q = session.createQuery("FROM Drink");
        try{
            trans = session.beginTransaction();
            session.save(drink);
            trans.commit();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Insert Dink Successful!");
            alert.show();
            this.reloadTable("");
        }
        catch(Exception ex){
            if(trans != null)
                trans.rollback();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Insert Dink Fail!");
            alert.show();
        }
        finally{
            session.close();
        }
    }
    //Cập Nhật Dữ Liệu
    @FXML
    private void updateDrinkHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            if(!txtDrinkID.getText().isEmpty()){
               Drink d = (Drink) session.get(Drink.class, Integer.parseInt(txtDrinkID.getText()));
               d.setIdDrink(Integer.parseInt(txtDrinkID.getText()));
               d.setNameDrink(txtNameDrink.getText());
               d.setPriceDrink(Double.parseDouble(txtPriceDrink.getText()));
               d.setDrinkCategory((DrinkCategory) this.cbCategoryName.getSelectionModel().getSelectedItem());
               Transaction trans = session.beginTransaction();
               session.update(d);
               trans.commit();
               this.reloadTable("");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Update Dink Successful!");
               alert.show();   
            }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Update Dink Fail!");
            alert.show();   
        }
        finally{
            session.close();
        }
    }
    //Xoá dữ liệu
    @FXML
    private void deleteDrinkHandler(ActionEvent event) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            if(!txtDrinkID.getText().isEmpty()){
               Drink d = (Drink) session.get(Drink.class, Integer.parseInt(txtDrinkID.getText()));
               d.setIdDrink(Integer.parseInt(txtDrinkID.getText()));
               d.setNameDrink(txtNameDrink.getText());
               d.setPriceDrink(Double.parseDouble(txtPriceDrink.getText()));
               d.setDrinkCategory((DrinkCategory) this.cbCategoryName.getSelectionModel().getSelectedItem());
               Transaction trans = session.beginTransaction();
               session.delete(d);
               trans.commit();
               this.reloadTable("");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Delete Dink Successful!");
               alert.show();   
            }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Delete Dink Fail!");
            alert.show();   
        }
        finally{
            session.close();
        }
    }    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Thoat chuong trinh
    @FXML
    private void exitProgram(ActionEvent evt) throws IOException { 
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setContentText("Do you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            //Xu ly chuyen Scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/FXMLLogin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)evt.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        }
    }
    
    //Reload Table
    private void reloadTable(String kw){
        //Reload table DrinkCategory
        this.tbDrinkCategory.getItems().clear();
        this.tbDrinkCategory.setItems(this.getDrinkCategories(kw));
        //Reload table Drink
        this.tbDrink.getItems().clear();
        this.tbDrink.setItems(this.getDrink(kw));
    }
    
    //Xu ly su kien tim kiem
    private void searchHandler(){
        this.txtSearch.textProperty().addListener(e -> {
            this.reloadTable(txtSearch.getText());
        });
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Override
    public void initialize(URL url, ResourceBundle rb){   
        //loại khách hàng
//        if(FXMLLoginController.getTypeNow() != 1) {
//            btCategory.setDisable(true);
//            btDrinkMenu.setDisable(true);
//        }
        //set tên khách hàng
        lbDisplayName.setText(FXMLLoginController.getdisplayNameNow());
        //Load bang Category
        this.colIDDrinkCategory.setCellValueFactory(new PropertyValueFactory("idDrinkCategory"));
        this.colDrinkCategoryName.setCellValueFactory(new PropertyValueFactory("nameDrinkCategory"));
        this.tbDrinkCategory.setItems(this.getDrinkCategories(""));
        //Xu ly tim kiem
        searchHandler();
        //Xu ly click tren mot dong DrinkCategory
        clickRowDrinkCategory();
        //Load bang Category
        this.colIDDrink.setCellValueFactory(new PropertyValueFactory("idDrink"));
        this.colNameDrink.setCellValueFactory(new PropertyValueFactory("nameDrink"));
        this.colPriceDrink.setCellValueFactory(new PropertyValueFactory("priceDrink"));
        this.colDrinkCategory.setCellValueFactory(new PropertyValueFactory("drinkCategory"));
        this.tbDrink.setItems(this.getDrink(""));
        //Xu ly click tren mot dong DrinkCategory
        clickRowDrink();
    }   
}
