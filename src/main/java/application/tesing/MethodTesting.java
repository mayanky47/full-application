package application.tesing;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.navigator.resources.ProjectStructure;

import static application.service.ControllerService.fillDataToAccordion;
import static project.navigator.ProjectStructureRetriever.retrieveRestProject;

public class MethodTesting extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Dynamic Form Example");

        String path = "C:\\Users\\Mayank\\Desktop\\testingData\\artifact-project";
        Accordion accordion = new Accordion();
        ProjectStructure projectStructure = retrieveRestProject(path);
        fillDataToAccordion(projectStructure, accordion, "controller");

        // Initialize the VBox that will hold the form fields
        VBox vbox = new VBox(10, accordion);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}