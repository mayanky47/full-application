package application.tesing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FormTesting extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Form");

        // Creating labels
        Label nameLabel = new Label("type");
        Label emailLabel = new Label("Modifier");
        Label passwordLabel = new Label("name");
        Label parametersLabel = new Label("parameters");

        // Creating text fields
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField passwordTextField = new TextField();
        TextField parametersTextField = new TextField();

        // Creating submit button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            // Handle form submission here
            String type = nameTextField.getText();
            String modifier = emailTextField.getText();
            String name = passwordTextField.getText();
            String parameters= parametersTextField.getText();
            System.out.println("Name: " + type + ", Email: " + modifier + ", Password: " + name+", Parameters: " + parameters);
        });

        // Creating layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding labels and text fields to the layout
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailTextField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordTextField, 1, 2);
        gridPane.add(parametersLabel, 0, 3);
        gridPane.add(parametersTextField, 1, 3);
        gridPane.add(submitButton, 0, 4);



        // Setting the scene
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
