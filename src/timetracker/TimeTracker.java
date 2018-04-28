/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Gus
 */
public class TimeTracker extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        URL fxml = getClass().getResource("/timetracker/Tela.fxml");
        Parent fxmlParent = null;
        try {
            fxmlParent = (Parent) FXMLLoader.load(fxml);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        if (fxmlParent != null) {
            Scene scene = new Scene(fxmlParent);

            primaryStage.setTitle("TimeTracker v0.01");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
