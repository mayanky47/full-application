package file.navigator.resources;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.SimpleName;

import java.io.File;
import java.util.List;

public class FileResource {
    File file;
    SimpleName name;
    NodeList<BodyDeclaration<?>> memberList;
    List<MethodDeclaration> methodList;
    CompilationUnit cu;

    public FileResource(File file, SimpleName name, NodeList<BodyDeclaration<?>> bodyList, List<MethodDeclaration> methodList, CompilationUnit cu) {
        this.file = file;
        this.name = name;
        this.memberList = bodyList;
        this.methodList = methodList;
        this.cu = cu;
    }

    public File getFile() {
        return file;
    }

    public SimpleName getName() {
        return name;
    }

    public void setName(SimpleName name) {
        this.name = name;
    }

    public NodeList<BodyDeclaration<?>> getMemberList() {
        return memberList;
    }

    public void setMemberList(NodeList<BodyDeclaration<?>> memberList) {
        this.memberList = memberList;
    }

    public List<MethodDeclaration> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<MethodDeclaration> methodList) {
        this.methodList = methodList;
    }

    public CompilationUnit getCu() {
        return cu;
    }

    public void setCu(CompilationUnit cu) {
        this.cu = cu;
    }

    @Override
    public String toString() {
        return "FileResource{" +
                "name=" + name +
                ", memberList=" + memberList +
                ", methodList=" + methodList +
                '}';
    }
}

