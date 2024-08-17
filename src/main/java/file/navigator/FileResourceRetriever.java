package file.navigator;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.TypeDeclaration;
import file.navigator.resources.FileResource;
import project.navigator.resources.ProjectStructure;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import static project.navigator.service.ProjectService.createPackage;


public class FileResourceRetriever {
    private static final String CONTROLLER = "controller";

    public static FileResource retrieverFileResource(ProjectStructure projectStructure, String fileSource){
        File file = new File(fileSource);

        try {
            // Parse the .java file
            JavaParser javaParser = new JavaParser();
            ParseResult<CompilationUnit> compilationUnit = javaParser.parse(file);
            // response
            Optional<CompilationUnit> c = compilationUnit.getResult();

            // Get the type declarations (classes, interfaces, etc.) in the file
            List<TypeDeclaration<?>> types = c.get().getTypes();

            //TypeDeclaration raw data
            TypeDeclaration<?> rawData= types.get(0);



            //creating controller package
            createPackage(projectStructure.getJavaClassPath(),CONTROLLER);

            //returning FileResource file
            return new FileResource(file,rawData.getName(),rawData.getMembers(),rawData.getMethods(),rawData.getFields(), c.get());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateJavaFile(String fileSource){

    }
}
