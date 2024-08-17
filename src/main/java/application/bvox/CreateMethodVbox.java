package application.bvox;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import lombok.Data;

@Data
public class CreateMethodVbox extends VBox {
    TextField annotationName;
    TextField annotationValue;
    TextField type;
    ComboBox<String> modifier;
    TextField name;
    TextField paramter_str;
    TextArea body;
    Button submit;


    public CreateMethodVbox() {
        Label annotationNameLabel = new Label("Annotation Name");
        Label annotationValueLabel = new Label("Annotation Value");
        Label type = new Label("Type");
        Label modifier = new Label("Modifier");
        Label name = new Label("Name");
        Label paramter_str = new Label("Paramter Str");
        Label body = new Label("Body");
        this.annotationName = new TextField();
        this.annotationValue = new TextField();
        this.type = new TextField();
        this.modifier = new ComboBox<>();
        this.name = new TextField();
        this.paramter_str = new TextField();
        this.body = new TextArea();
        this.body.setEditable(true);
        this.body.setPrefRowCount(5);
        this.submit = new Button("Submit");

        //populating comboBox
        this.modifier.getItems().addAll("private", "public", "protected");
        this.modifier.setValue("private");

        // Adding
        this.getChildren().addAll(annotationNameLabel, this.annotationName, annotationValueLabel, this.annotationValue, type, this.type,modifier,this.modifier, name,this.name, paramter_str,this.paramter_str, body , this.body,this.submit);

        //styling
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setStyle("-fx-background-color: lightblue;");
    }
}
