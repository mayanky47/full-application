package application.tesing;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainTesting2 extends Application {



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Expanded TitledPanes");

        // Creating Accordion
        Accordion accordion = new Accordion();

        // Creating first TitledPane with a button initially
        TitledPane titledPane1 = new TitledPane();
        VBox content1 = new VBox(10);
        Button openButton1 = new Button("Open Form 1");
        openButton1.setOnAction(e -> {
            if (content1.getChildren().size() == 1) { // Only add form if it's not already added
                content1.getChildren().add(createForm("Name 1:", "Email 1:", "Password 1:"));
                accordion.setExpandedPane(titledPane1);
            }
        });
        content1.getChildren().add(openButton1); // Add button initially
        titledPane1.setContent(content1);
        titledPane1.setText("TitledPane 1");
        accordion.getPanes().add(titledPane1);

        // Creating second TitledPane with a button initially
        TitledPane titledPane2 = new TitledPane();
        VBox content2 = new VBox(10);
        Button openButton2 = new Button("Open Form 2");
        openButton2.setOnAction(e -> {
            if (content2.getChildren().size() == 1) { // Only add form if it's not already added
                content2.getChildren().add(createForm("Name 2:", "Email 2:", "Password 2:"));
                accordion.setExpandedPane(titledPane2);
            }
        });
        content2.getChildren().add(openButton2); // Add button initially
        titledPane2.setContent(content2);
        titledPane2.setText("TitledPane 2");
        accordion.getPanes().add(titledPane2);

        // Setting the scene
        VBox root = new VBox(10, accordion);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Adding listener to track expanded TitledPane
        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldPane, TitledPane newPane) {
                if (newPane != null) {
                    System.out.println("Expanded TitledPane: " + newPane.getText());
                }
            }
        });
    }

    // Helper method to create a full form
    private VBox createForm(String nameLabel, String emailLabel, String passwordLabel) {
        // Creating labels
        Label name = new Label(nameLabel);
        Label email = new Label(emailLabel);
        Label password = new Label(passwordLabel);

        // Creating text fields
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField passwordTextField = new TextField();

        // Creating layout
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        // Adding labels and text fields to the layout
        vbox.getChildren().addAll(name, nameTextField, email, emailTextField, password, passwordTextField);

        return vbox;
    }
    public static void main(String[] args) {
        launch(args);
    }
}