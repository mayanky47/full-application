package application.bvox;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;


@Data
public class RestApplicationVbox extends VBox {
    private Label label;
    private Button selectProjectButton;
    private Label projectNameLabel;

    private TextField classNameTextField;
    private Button createClassButton;
    private Button createMethodButton;
    private HBox classInputBox;
    private Accordion classListAccordion;


    ComboBox<String> packages;

    public RestApplicationVbox() {
        //Creating Component ------------------------
        label = new Label("Inside Rest Application page");
        label.setStyle("-fx-font-size: 30pt; -fx-font-weight: bold; -fx-text-fill: #0077cc;");
        selectProjectButton = new Button("Select Project");
        projectNameLabel = new Label("Project Name");


        //Accordion
        this.createMethodButton = new Button("Create Method");
        this.classListAccordion = new Accordion();


        // classInputBox
        this.classNameTextField = new TextField();
        classNameTextField.setPromptText("Enter new class Name");
        this.createClassButton = new Button("Create Class");
        this.classInputBox = new HBox(5, classNameTextField, createClassButton);
        this.classInputBox.setAlignment(Pos.BOTTOM_CENTER);


        //packages
        this.packages = new ComboBox<>();

        // Adding Component
        this.getChildren().addAll(this.label, this.selectProjectButton);
        //Styling
        this.setAlignment(Pos.CENTER);

    }}