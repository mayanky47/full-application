package project.navigator.service;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ProjectService {

    public static Model getProjectMavenModel(String fileLocation) {
        File pomFile = new File(fileLocation);
        // Initialize the MavenXpp3Reader
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;

        try (FileReader fileReader = new FileReader(pomFile)) {
            // Read the pom.xml file into the model
            model = reader.read(fileReader);
            return model;
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createPackage(Path javaClassPath, String packageName) {
        Path path = javaClassPath.resolve(packageName);
        new File(String.valueOf(path)).mkdirs();
    }

    public static List<Path> traverseDirectory(Path directory) {
        try {
            List<Path> fileList = new ArrayList<>();
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".java")) {
                        fileList.add(directory.relativize(file));
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Failed to visit file: " + file + " (" + exc.getMessage() + ")");
                    return FileVisitResult.CONTINUE;
                }
            });
            return fileList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
