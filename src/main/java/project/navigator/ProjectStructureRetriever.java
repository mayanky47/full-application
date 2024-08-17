package project.navigator;


import org.apache.maven.model.Model;
import project.navigator.resources.ProjectStructure;


import static project.navigator.service.ProjectService.getProjectMavenModel;
import static project.navigator.utility.ProjectBuilder.buildProject;


public class ProjectStructureRetriever {
    public static ProjectStructure retrieveRestProject(String path){

        Model model = getProjectMavenModel(path+"/pom.xml");
        if (model != null){
            return buildProject(path,model);
             }
        return null;
    }
}
