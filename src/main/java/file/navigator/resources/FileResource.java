package file.navigator.resources;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.SimpleName;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class FileResource {
    File file;
    SimpleName name;
    NodeList<BodyDeclaration<?>> memberList;
    List<MethodDeclaration> methodList;
    List<FieldDeclaration> fieldList;
    CompilationUnit cu;

    public FileResource(File file, SimpleName name, NodeList<BodyDeclaration<?>> bodyList, List<MethodDeclaration> methodList, List<FieldDeclaration> fieldList,CompilationUnit cu) {
        this.file = file;
        this.name = name;
        this.memberList = bodyList;
        this.methodList = methodList;
        this.fieldList = fieldList;
        this.cu = cu;
    }

}

