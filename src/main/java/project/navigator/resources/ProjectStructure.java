package project.navigator.resources;

import lombok.Data;

import java.nio.file.Path;
import java.util.List;

@Data
public class ProjectStructure {
    String projectName;
    Path projectPath;
    List<Path> controllerClasses;
    List<Path> packages;
    Path groupId;
    Path artifactId;
    Path javaClassPath;
    String currentDirectory;
    String currentFileName;

    public ProjectStructure(String projectName, Path projectPath,List<Path> controllerClasses,List<Path> packages, Path groupId, Path artifactId,Path javaClassPath){
        this.projectName = projectName;
        this.projectPath = projectPath;
        this.controllerClasses = controllerClasses;
        this.packages = packages;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.javaClassPath = javaClassPath;
    }

}
