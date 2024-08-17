package project.navigator.utility;


import org.apache.maven.model.Model;
import project.navigator.resources.ProjectStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static project.navigator.service.ProjectService.createPackage;
import static project.navigator.service.ProjectService.traverseDirectory;


public class ProjectBuilder {

    private static String CONTROLLER= "controller";


    public static ProjectStructure buildProject(String path, Model model){
        String name = model.getName();
        Path projectPath = Paths.get(path);
        Path artifactId = Paths.get(model.getArtifactId().replace("-","_"));
        Path groupId = Paths.get(model.getGroupId().replace("-","_"));

        Path javaClassPath = projectPath.resolve("src/main/java").resolve(groupId.toString().replace(".","/")).resolve(artifactId.toString().replace(".","/"));
        createPackage(javaClassPath,CONTROLLER);
        Path controllerDirectory = javaClassPath.resolve(CONTROLLER);
        List<Path> controllerClasses = traverseDirectory(controllerDirectory);
        if (controllerClasses == null){
            controllerClasses = new ArrayList<>();
        }

        List<Path> packages = packageFinder(javaClassPath);
        if (packages == null){
            packages = new ArrayList<>();
        }
        return new ProjectStructure(name, projectPath,controllerClasses,packages,groupId, artifactId,javaClassPath);
    }

    public static List<Path> packageFinder(Path path){
        try {
            List<String> directories = List.of(path.toFile().list((current, name) -> new File(current, name).isDirectory()));
            List<Path> files = directories.stream().map(Paths::get).collect(Collectors.toList());
            return files;
        } catch (Exception e) {
            return null;
        }
    }
}
