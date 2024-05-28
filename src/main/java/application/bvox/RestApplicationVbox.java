package application.bvox;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class RestApplicationVbox extends VBox {
    private Label label;
    private Button selectProjectButton;
    private Label projectNameLabel;
    public RestApplicationVbox() {

        //Creating Component
        label = new Label("Inside Rest Application page");
        label.setStyle("-fx-font-size: 30pt; -fx-font-weight: bold; -fx-text-fill: #0077cc;");

        selectProjectButton = new Button("Select Project");

        projectNameLabel = new Label("Project Name");


        // Adding Component
        this.getChildren().addAll(this.label, this.selectProjectButton);

        //Styling
        this.setAlignment(Pos.CENTER);

    }

    public Label getLabel() {
        return label;
    }
    public Button getSelectProjectButton() {
        return selectProjectButton;
    }
    public Label getProjectNameLabel() {
        return projectNameLabel;
    }
    public void setProjectNameLabel(String label) {
        this.projectNameLabel.setText(label);
    }

}
