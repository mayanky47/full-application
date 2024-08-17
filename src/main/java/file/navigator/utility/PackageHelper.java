package file.navigator.utility;

import project.navigator.resources.ProjectStructure;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PackageHelper {
    public static String packageBuilder(ProjectStructure projectStructure, String packageName){
        return projectStructure.getGroupId()+"."+projectStructure.getArtifactId()+"."+packageName;
    }

    public static String sourceFileBuilder(ProjectStructure projectStructure, String packageName,String fileName){
        Path path = Paths.get(projectStructure.getJavaClassPath().toUri()).resolve(packageName).resolve(fileName);
        return path.toString();
    }
}
