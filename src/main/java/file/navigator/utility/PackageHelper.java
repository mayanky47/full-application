package file.navigator.utility;

import com.project.navigator.resources.ProjectStructure;

public class PackageHelper {
    public static String packageBuilder(ProjectStructure projectStructure, String packageName){
        return projectStructure.getGroupId()+"."+projectStructure.getArtifactId()+"."+packageName;
    }
}
