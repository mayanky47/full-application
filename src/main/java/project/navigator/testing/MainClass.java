package project.navigator.testing;

import file.navigator.resources.FileResource;
import project.navigator.resources.ProjectStructure;

import java.io.File;

import static file.navigator.FileResourceRetriever.retrieverFileResource;
import static project.navigator.ProjectStructureRetriever.retrieveRestProject;
import static project.navigator.utility.ProjectBuilder.packageFinder;

public class MainClass {

    public static void main(String[] args) {

        String path = "C:\\Users\\Mayank\\Desktop\\testingData\\artifact-project";
        ProjectStructure projectStructure = retrieveRestProject(path);
        File sourceFile = projectStructure.getJavaClassPath().resolve("controller").resolve(projectStructure.getControllerClasses().get(0)).toFile();
        FileResource fileResource = retrieverFileResource(projectStructure, String.valueOf(sourceFile));

        ProjectStructure p = retrieveRestProject(path);
        System.out.println(p.getPackages());


        File directory = new File(path);

        // Verify if it's a directory
//        if (directory.isDirectory()) {
            // Get list of all files and directories in the specified directory
    }
}
