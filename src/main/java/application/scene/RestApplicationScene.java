package application.scene;


import application.bvox.CreateMethodVbox;
import application.bvox.RestApplicationVbox;
import application.controller.ScreenController;
import com.github.javaparser.ast.body.MethodDeclaration;
import file.navigator.resources.FileResource;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import project.navigator.resources.ProjectStructure;

import java.nio.file.Path;

import static application.service.ControllerService.*;
import static application.utility.DirectoryHelper.getDirectory;
import static file.navigator.FileResourceRetriever.retrieverFileResource;
import static file.navigator.services.ClassCreation.addMethodToTheClassFile;
import static file.navigator.services.MethodCreation.createMethod;
import static file.navigator.services.MethodCreation.createMethodWithAnnotation;
import static file.navigator.utility.PackageHelper.sourceFileBuilder;
import static project.navigator.ProjectStructureRetriever.retrieveRestProject;


public class RestApplicationScene extends Scene {

    public RestApplicationScene(ScreenController controller, double width, double height) {
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

        CreateMethodVbox createMethodVbox = new CreateMethodVbox();

        // VBOX's event handling
        restApplicationVbox.getSelectProjectButton().setOnAction(
                event -> {
                    // retrieving the Project Structure
                    String path = getDirectory(controller.getPrimaryStage());
                    if (path != null) {
                        ProjectStructure projectStructure = retrieveRestProject(path);
                        controller.setProjectStructure(projectStructure);

                        restApplicationVbox.setProjectNameLabel(new Label(projectStructure.getProjectName()));
                        restApplicationVbox.getProjectNameLabel().setStyle("-fx-font-size: 20pt; -fx-font-weight: bold; -fx-text-fill: #FFC300;");
                        restApplicationVbox.getChildren().add(restApplicationVbox.getProjectNameLabel());

                        for (Path packageItem : projectStructure.getPackages()) {
                            restApplicationVbox.getPackages().getItems().add(packageItem.toString());
                        }
                        restApplicationVbox.getPackages().setValue(restApplicationVbox.getPackages().getItems().get(0));
                        restApplicationVbox.getChildren().add(restApplicationVbox.getPackages());

                        restApplicationVbox.getChildren().add(restApplicationVbox.getClassInputBox());

                        restApplicationVbox.getChildren().remove(restApplicationVbox.getSelectProjectButton());
                        ;

                    }

                });

        // when select different package from combo box
        restApplicationVbox.getPackages().valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                controller.getProjectStructure().setCurrentDirectory(newValue);
                if (oldValue != null) {
                    Accordion accordion = restApplicationVbox.getClassListAccordion();
                    fillDataToAccordion(controller.getProjectStructure(), accordion, controller.getProjectStructure().getCurrentDirectory());
                } else {
                    Accordion accordion = restApplicationVbox.getClassListAccordion();
                    fillDataToAccordion(controller.getProjectStructure(), accordion, controller.getProjectStructure().getCurrentDirectory());

                    VBox vbox = new VBox(10, accordion);
                    vbox.setAlignment(Pos.BOTTOM_CENTER);
                    vbox.getChildren().add(restApplicationVbox.getCreateMethodButton());
                    rootVbox.getChildren().add(vbox);
                }
            }
        });

        // when create class button get clicked
        restApplicationVbox.getCreateClassButton().setOnAction(
                e -> {
                    ProjectStructure projectStructure = controller.getProjectStructure();
                    addItemToClassList(projectStructure, restApplicationVbox.getClassNameTextField(), restApplicationVbox.getClassListAccordion());
                }
        );

        // when creat method button get clicked
        restApplicationVbox.getCreateMethodButton().setOnAction(
                e -> {
                    if (controller.getProjectStructure().getCurrentFileName() != null) {
                        if (!rootVbox.getChildren().contains(createMethodVbox)) {
                            rootVbox.getChildren().add(createMethodVbox);
                        }


                    }

                }
        );

        // when submit button get clicked inside method creation
        createMethodVbox.getSubmit().setOnAction((
                e -> {
                    // data gathering
                    String annotationName = createMethodVbox.getAnnotationName().getText();
                    String annotationValue = createMethodVbox.getAnnotationValue().getText();
                    String modifier = createMethodVbox.getModifier().getValue();
                    String type = createMethodVbox.getType().getText();
                    String name = createMethodVbox.getName().getText();
                    String paramter = createMethodVbox.getParamter_str().getText();
                    String body = createMethodVbox.getBody().getText();

                    ProjectStructure projectStructure = controller.getProjectStructure();

                    FileResource fileResource = retrieverFileResource(projectStructure, sourceFileBuilder(projectStructure, projectStructure.getCurrentDirectory(), projectStructure.getCurrentFileName()));

                    // Method creation
                    MethodDeclaration methodDeclaration =
                            !annotationName.isEmpty()
                                    ?
                                    createMethodWithAnnotation(type, modifier, name, paramter, body, annotationName, annotationValue)
                                    :
                                    createMethod(type, modifier, name, paramter, body);

                    // call to backend
                    addMethodToTheClassFile(fileResource, methodDeclaration);

                    // cleaning

                    createMethodVbox.getType().clear();
                    createMethodVbox.getName().clear();
                    createMethodVbox.getParamter_str().clear();
                    createMethodVbox.getBody().clear();
                    rootVbox.getChildren().remove(createMethodVbox);

                    //updating classes on the screen
                    fillDataToAccordion(projectStructure, restApplicationVbox.getClassListAccordion(), projectStructure.getCurrentDirectory());


                }
        ));


        // Adding listener to track expanded TitledPane
        restApplicationVbox.getClassListAccordion().expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observable, TitledPane oldPane, TitledPane newPane) {
                if (newPane != null) {
                    controller.getProjectStructure().setCurrentFileName(newPane.getText());
                }
            }
        });

        // adding to the layout
        //Vbox
        rootVbox.getChildren().addAll(topScreen, restApplicationVbox);

        // style
        this.getStylesheets().add("static/style.css");

    }
}
