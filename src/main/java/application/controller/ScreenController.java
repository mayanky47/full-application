package application.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import project.navigator.resources.ProjectStructure;

import java.util.HashMap;

public class ScreenController {

    private Stage primaryStage;
    private HashMap<String, Scene> screenMap = new HashMap<>();
    ProjectStructure projectStructure;

    public ScreenController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addScreen(String name, Scene scene) {
        screenMap.put(name, scene);
    }

    public void activate(String name) {
        primaryStage.setScene(screenMap.get(name));
        primaryStage.setFullScreen(true);
        primaryStage.isResizable();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setProjectStructure(ProjectStructure projectStructure) {
        this.projectStructure = projectStructure;
    }
    public ProjectStructure getProjectStructure() {
        return projectStructure;
    }
}
