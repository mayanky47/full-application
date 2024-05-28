package file.navigator.services;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.project.navigator.resources.ProjectStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static com.file.navigator.services.ClassCreation.createClass;
import static com.file.navigator.utility.PackageHelper.packageBuilder;

public class FileCreation {


    public static void createFile(ProjectStructure projectStructure, String packageName, String className) {
        String packageLoc = packageBuilder(projectStructure,packageName);
        Path path = projectStructure.getJavaClassPath().resolve(packageName+"/"+className+".java");
        try {
            File myObj = new File(String.valueOf(path));
            if(!myObj.exists()) {
                myObj.createNewFile();
                System.out.println(myObj);
                Name name = new Name(packageLoc);
                PackageDeclaration packageDeclaration = new PackageDeclaration(name);
                CompilationUnit cu = new CompilationUnit(packageLoc);
                cu.addClass(className);
                createClass(cu,myObj);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPackage(Path javaClassPath,String packageName) {
        Path path = javaClassPath.resolve(packageName);
        new File(String.valueOf(path)).mkdirs();
    }
}
