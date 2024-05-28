package application.utility;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class DirectoryHelper {

    public static String getDirectory(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedFolder = directoryChooser.showDialog(stage);
        if (selectedFolder != null) {
            return selectedFolder.getAbsolutePath();
        } else {
            return null;
        }
    }
}
