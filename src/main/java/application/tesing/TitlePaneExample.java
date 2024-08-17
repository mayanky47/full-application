package application.tesing;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class TitlePaneExample extends Application {
    public void start(Stage primaryStage) {
        TitledPane titledPane = new TitledPane("Title Pane", new VBox());
        TitledPane titledPane2 = new TitledPane("Title Pane2", new VBox());
        titledPane.setPrefSize(400, 1000);  // Set preferred width and height

        Scene scene = new Scene(new VBox(titledPane,titledPane2), 500, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Title Pane Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

