package application.tesing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainTesting extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multiple TitledPanes");

        // Creating Accordion
        Accordion accordion = new Accordion();

        // Creating first TitledPane with full form content
        TitledPane titledPane1 = new TitledPane();
        VBox form1 = createForm("Name 1:", "Email 1:", "Password 1:");
        titledPane1.setContent(form1);
        titledPane1.setText("Form 1");
        Button openButton1 = new Button("Open");
        openButton1.setOnAction(e -> titledPane1.setExpanded(!titledPane1.isExpanded())); // Toggle expansion
        titledPane1.setGraphic(openButton1); // Set button as part of title area
        accordion.getPanes().add(titledPane1);

        // Creating second TitledPane with full form content
        TitledPane titledPane2 = new TitledPane();
        VBox form2 = createForm("Name 2:", "Email 2:", "Password 2:");
        titledPane2.setContent(form2);
        titledPane2.setText("Form 2");
        Button openButton2 = new Button("Open");
        openButton2.setOnAction(e -> titledPane2.setExpanded(!titledPane2.isExpanded())); // Toggle expansion
        titledPane2.setGraphic(openButton2); // Set button as part of title area
        accordion.getPanes().add(titledPane2);

        // Setting the scene
        VBox root = new VBox(10, accordion);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
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