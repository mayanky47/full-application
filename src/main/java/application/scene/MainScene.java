package application.scene;

import application.bvox.MainScreenVbox;
import application.controller.ScreenController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class MainScene extends Scene {


    public MainScene(ScreenController controller, double width, double height) {
    // making new layout-------------------------------
        super(new VBox(10), width, height);
        VBox rootVbox = (VBox) this.getRoot();
        rootVbox.setAlignment(Pos.TOP_CENTER);

    //creating Vbox -------------------------------------
        //*************************
        // Close button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> controller.getPrimaryStage().close());
        // creating vbox to add close button
        VBox topScreen = new VBox();
        topScreen.setAlignment(Pos.TOP_RIGHT);
        topScreen.getChildren().add(closeButton);
        //****************************

        MainScreenVbox mainScreenVbox = new MainScreenVbox();

        // Vbox's allignment
        mainScreenVbox.setAlignment(Pos.CENTER);

    // VBOX's event handling
            mainScreenVbox.getRestApplicationButton().setOnAction(e -> controller.activate("restScene"));

    // adding to the layout
        //Vbox
        rootVbox.getChildren().addAll(topScreen,mainScreenVbox);

    // adding to the scene
        this.getStylesheets().add("static/style.css");



    }


}

