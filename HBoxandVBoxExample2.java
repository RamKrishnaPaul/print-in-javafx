/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hboxvbox;

/**
 *
 * @author Ram Krishna Paul
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HBoxandVBoxExample2 extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {                
        StackPane root = new StackPane();
                 
        HBox hbox = new HBox(30); // create a HBox to hold 2 vboxes        
         
        // create a vbox with a textarea that grows vertically
        VBox vbox = new VBox(10);        
        Label lbName = new Label("I´m a label!");
        TextField textField = new TextField();
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(100);
        VBox.setVgrow(textArea, Priority.ALWAYS);        
        vbox.getChildren().addAll(lbName, textField, textArea);
         
        // create a vbox that grows horizontally inside the hbox
        VBox vbox2 = new VBox(10);        
        Label lbName2 = new Label("I´m also a label!");
        TextField tf2 = new TextField();
        tf2.setPromptText("type here");
        TextArea textArea2 = new TextArea();
        textArea2.setPrefWidth(100);
        vbox2.getChildren().addAll(lbName2, tf2, textArea2);
           
        HBox.setHgrow(vbox2, Priority.ALWAYS);
 
        // the next two lines behave equally - try to comment the first line out and use the 2nd line
        hbox.setPadding(new Insets(20));
//        StackPane.setMargin(hbox, new Insets(20));
 
        hbox.getChildren().addAll(vbox, vbox2);
        root.getChildren().add(hbox);
        Scene scene = new Scene(root, 500, 300); // the stack pane is the root node
         
        primaryStage.setTitle("HBox and VBox Example 2");
        primaryStage.setScene(scene);
        primaryStage.show();        
    }
 
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}