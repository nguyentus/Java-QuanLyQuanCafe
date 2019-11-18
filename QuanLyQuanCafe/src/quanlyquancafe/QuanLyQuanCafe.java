/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyquancafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author nguyenthanhtu
 */
public class QuanLyQuanCafe extends Application {
    private Stage window;
    private Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception {
    try {
            window = primaryStage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/FXMLHome.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            window.setTitle("Program Of Managing Coffee Shop");
            window.setResizable(false);
            window.setScene(scene);
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            window.show();
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
            window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        }catch (Exception e) {
                e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
