/**
 *
 * @author Jacob Jones
 * Date - 12/14/2019
 * 
 * This program will accept a list of numbers from the user, and will then print
 * the highest number, lowest number, sum, and average of the list
 */
package jjonesnumberanalyzer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JJonesNumberAnalyzer extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        // Sets up the layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        
        // Sets up the scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Number Analyzer");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Sets up the header
        Label header = new Label("Number Analyzer");
        header.setFont(new Font(30));
        header.setPadding(new Insets(30));
        
        // Sets up the row that asks for the numbers
        Label numLabel = new Label("Enter numbers here:");
        TextField numField = new TextField();
        
        // Puts the label and field into a row
        HBox numGetters = new HBox(numLabel, numField);
        numGetters.setAlignment(Pos.CENTER);
        numGetters.setSpacing(10);
        
        // The area for the information to print into
        TextArea output = new TextArea();
        output.setEditable(false);
        
        // The button to show the Integer information
        Button intBtn = new Button();
        intBtn.setText("Integer");
        intBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // The variables
                String text = numField.getText(); // The obtained text
                String newText[] = text.split(" "); // The text split into an array of strings
                Integer list[] = new Integer[newText.length]; // The list of numbers from the text
                
                // Puts the numbers from the string list into the number list
                for(int i = 0; i < list.length; i++){
                    list[i] = Integer.parseInt(newText[i]);
                }
                
                // Creates a GenericNumber object to store the numbers
                GenericNumber<Integer> intList = new GenericNumber<>(list);
                
                // Prints out the information about the numbers
                String outputText = getOutput(intList);
                output.setText(outputText);
            }
        });
        
        // The button to show the Long information
        Button longBtn = new Button();
        longBtn.setText("Long");
        longBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // The variables
                String text = numField.getText(); // The obtained text
                String newText[] = text.split(" "); // The text split into an array of strings
                Long list[] = new Long[newText.length]; // The list of numbers from the text
                
                // Puts the numbers from the string list into the number list
                for(int i = 0; i < list.length; i++){
                    list[i] = Long.parseLong(newText[i]);
                }
                
                // Creates a GenericNumber object to store the numbers
                GenericNumber<Long> intList = new GenericNumber<>(list);
                
                // Prints out the information about the numbers
                String outputText = getOutput(intList);
                output.setText(outputText);
            }
        });
        
        // The button to show the Double information
        Button doubleBtn = new Button();
        doubleBtn.setText("Double");
        doubleBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // The variables
                String text = numField.getText(); // The obtained text
                String newText[] = text.split(" "); // The text split into an array of strings
                Double list[] = new Double[newText.length]; // The list of numbers from the text
                
                // Puts the numbers from the string list into the number list
                for(int i = 0; i < list.length; i++){
                    list[i] = Double.parseDouble(newText[i]);
                }
                
                // Creates a GenericNumber object to store the numbers
                GenericNumber<Double> intList = new GenericNumber<>(list);
                
                // Prints out the information about the numbers
                String outputText = getOutput(intList);
                output.setText(outputText);
            }
        });
        
        // The button to show the Float information
        Button floatBtn = new Button();
        floatBtn.setText("Float");
        floatBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                // The variables
                String text = numField.getText(); // The obtained text
                String newText[] = text.split(" "); // The text split into an array of strings
                Double list[] = new Double[newText.length]; // The list of numbers from the text
                
                // Puts the numbers from the string list into the number list
                for(int i = 0; i < list.length; i++){
                    list[i] = Double.parseDouble(newText[i]);
                }
                
                // Creates a GenericNumber object to store the numbers
                GenericNumber<Double> intList = new GenericNumber<>(list);
                
                // Prints out the information about the numbers
                String outputText = getOutput(intList);
                output.setText(outputText);
            }
        });
        
        // Resets the text field and output field
        Button resetBtn = new Button();
        resetBtn.setText("Reset");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                numField.setText("");
                output.setText("");
            }
        });
        
        // Combines all of the buttons into a row
        HBox buttonRow = new HBox(intBtn, longBtn, doubleBtn, floatBtn, resetBtn);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setSpacing(10);
        
        // Combines all of the fields and rows into a column
        VBox infoCol = new VBox(header, numGetters, buttonRow, output);
        infoCol.setAlignment(Pos.CENTER);
        infoCol.setSpacing(10);
        
        // Adds the column to the layout
        layout.add(infoCol, 0, 0);
    }
    
    /**
     * 
     * This method will print out the information from the list
     * 
     * @param list - The list to be printed from
     * 
     */
    public String getOutput(GenericNumber<? extends Number> list){
        String outputText = "The highest number in the list is: " + list.getHighest() + "\n";
        outputText += "The lowest number in the list is: " + list.getLowest() + "\n";
        outputText += "The sum of the list is: " + String.format("%.2f", list.getSum()) + "\n";
        outputText += "The average of the list is: " + String.format("%.2f", list.getAverage()) + "\n";
        return outputText;
    }
    
}
