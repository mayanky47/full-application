package application;

import application.controller.ScreenController;
import application.scene.MainScene;
import application.scene.RestApplicationScene;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Application");

        // Adding screen Controller
        ScreenController screenController = new ScreenController(primaryStage);



    // Screens part ---------------------------------------------------------
        // Create Main Screen
        MainScene mainScene = new MainScene(screenController,primaryStage.getWidth(), primaryStage.getHeight());

        // Create RestApplication Screen
        RestApplicationScene restApplicationScene = new RestApplicationScene(screenController,primaryStage.getWidth(), primaryStage.getHeight());


// Add screen to Controller ----------------------------------------------------------------
        screenController.addScreen("restScene", restApplicationScene);
        screenController.addScreen("mainScene", mainScene);




// Initial visibility ------------------------------------------------
        screenController.activate("mainScene");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
