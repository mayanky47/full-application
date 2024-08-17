package application.service;

import application.bvox.CreateMethodVbox;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import file.navigator.resources.FileResource;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import project.navigator.resources.ProjectStructure;

import java.nio.file.Path;
import java.util.List;

import static file.navigator.FileResourceRetriever.retrieverFileResource;
import static file.navigator.services.FileCreation.createFile;
import static file.navigator.utility.PackageHelper.sourceFileBuilder;
import static project.navigator.service.ProjectService.traverseDirectory;

public class ControllerService {

    public static int getIndex(VBox vbox, String id) {
        for (Node node : vbox.getChildren()) {
            if (!(node.getId() == null) && node.getId().equals(id)) {
                return vbox.getChildren().indexOf(node);
            }
        }
        return -1;
    }

    public static void fillDataToAccordion(ProjectStructure projectStructure, Accordion accordion, String packageName) {
        accordion.getPanes().clear();
        Path packageDirectory = projectStructure.getJavaClassPath().resolve(packageName);
        List<Path> classes = traverseDirectory(packageDirectory);
        if (classes != null) {

            for (Path path : classes) {
                TitledPane newTitledPane = new TitledPane();


                newTitledPane.setText(path.toString());
                VBox vbox = new VBox();
                vbox.setPrefHeight(1400);
                VBox fieldContent = new VBox();
                fieldContent.setPrefHeight(400);
                TitledPane methodTitlePane = new TitledPane();

                VBox methodContent = new VBox();
                methodContent.setPrefHeight(100);


                // backend call
                FileResource fileResource = retrieverFileResource(projectStructure, sourceFileBuilder(projectStructure, packageName, path.toString()));

                // data population

                // annotation

                //name


                //Field
                for (FieldDeclaration fieldDeclaration : fileResource.getFieldList()) {
                    Label label = new Label(fieldDeclaration.toString());
                    label.setStyle(
                            "-fx-background-color: lightblue; " +  // Background color
                                    "-fx-border-color: darkblue; " +      // Border color
                                    "-fx-border-width: 2; " +             // Border width
                                    "-fx-padding: 10;"                    // Padding
                    );
                    fieldContent.getChildren().add(label);
                }
                //method
                for (MethodDeclaration methodDeclaration : fileResource.getMethodList()) {
                    Button methodButton = new Button(methodDeclaration.getName().asString());
                    methodContent.getChildren().add(methodButton);
                }
                ;

                methodTitlePane.setContent(methodContent);
                vbox.getChildren().addAll(fieldContent,methodTitlePane);
                ScrollPane scrollPane = new ScrollPane(vbox);
                newTitledPane.setContent(scrollPane);
                accordion.getPanes().add(newTitledPane);
            }
        }
    }

    public static void addItemToClassList(ProjectStructure projectStructure, TextField itemNameField, Accordion accordion) {
        String itemName = itemNameField.getText();
        if (!itemName.isEmpty()) {

            // Backend call****************
            createFile(projectStructure, projectStructure.getCurrentDirectory(), itemName);

            //**********************

            TitledPane newTitledPane = new TitledPane();
            newTitledPane.setText(itemName+".java");
            VBox content = new VBox();

            newTitledPane.setContent(content);
            accordion.getPanes().add(newTitledPane);
            itemNameField.clear(); // Clear input box
        }
    }

    public static VBox getForm() {
        return new CreateMethodVbox();
    }

}
