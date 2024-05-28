package project.navigator.resources;

import java.nio.file.Path;
import java.util.List;

public class ProjectStructure {
    String projectName;
    Path projectPath;
    List<Path> controllerClasses;
    Path groupId;
    Path artifactId;
    Path javaClassPath;
    String currentDirectory;

    public ProjectStructure(String projectName, Path projectPath,List<Path> controllerClasses,Path groupId, Path artifactId,Path javaClassPath){
        this.projectName = projectName;
        this.projectPath = projectPath;
        this.controllerClasses = controllerClasses;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.javaClassPath = javaClassPath;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Path getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(Path projectPath) {
        this.projectPath = projectPath;
    }

    public List<Path> getControllerClasses() {
        return controllerClasses;
    }

    public void setControllerClasses(List<Path> controllerClasses) {
        this.controllerClasses = controllerClasses;
    }

    public Path getGroupId() {
        return groupId;
    }

    public void setGroupId(Path groupId) {
        this.groupId = groupId;
    }

    public Path getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(Path artifactId) {
        this.artifactId = artifactId;
    }

    public Path getJavaClassPath() {
        return javaClassPath;
    }

    public void setJavaClassPath(Path javaClassPath) {
        this.javaClassPath = javaClassPath;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }
    public void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public String toString() {
        return "ProjectStructure{" +
                "projectName='" + projectName + '\'' +
                ", projectPath=" + projectPath +
                ", controllerClasses=" + controllerClasses +
                ", groupId=" + groupId +
                ", artifactId=" + artifactId +
                ", javaClassPath=" + javaClassPath +
                '}';
    }
}
