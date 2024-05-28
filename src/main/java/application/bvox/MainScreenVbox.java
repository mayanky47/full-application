package application.bvox;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainScreenVbox extends VBox {
    private Button restApplicationButton;

    public MainScreenVbox(){

        // Adding component
        this.restApplicationButton = new Button("Make Rest Application");
        this.getChildren().add(this.restApplicationButton);

        // Styling
        this.setAlignment(Pos.CENTER);

    }

    public Button getRestApplicationButton(){
        return this.restApplicationButton;
    }
}
