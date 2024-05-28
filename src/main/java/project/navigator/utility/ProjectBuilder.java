package project.navigator.utility;


import org.apache.maven.model.Model;
import project.navigator.resources.ProjectStructure;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
        return new ProjectStructure(name, projectPath,controllerClasses,groupId, artifactId,javaClassPath);
    }
}
