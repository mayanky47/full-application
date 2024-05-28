package application.scene;


import application.bvox.RestApplicationVbox;
import application.controller.ScreenController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import project.navigator.resources.ProjectStructure;

import static application.utility.DirectoryHelper.getDirectory;
import static project.navigator.ProjectStructureRetriever.retrieveRestProject;


public class RestApplicationScene extends Scene {

    public RestApplicationScene(ScreenController controller, double width, double height){
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

        RestApplicationVbox restApplicationVbox = new RestApplicationVbox();

    // VBOX's event handling
        restApplicationVbox.getSelectProjectButton().setOnAction(
                event -> {
                    String path = getDirectory(controller.getPrimaryStage());
                    if (path != null) {
                        ProjectStructure projectStructure =retrieveRestProject(path);
                        restApplicationVbox.setProjectNameLabel(projectStructure.getProjectName());
                        restApplicationVbox.getChildren().add(restApplicationVbox.getProjectNameLabel());
                        restApplicationVbox.getChildren().remove(restApplicationVbox.getSelectProjectButton());
                    }

                });

    // adding to the layout
        //Vbox
        rootVbox.getChildren().addAll(topScreen,restApplicationVbox);

        // style
        this.getStylesheets().add("static/style.css");

    }
}
