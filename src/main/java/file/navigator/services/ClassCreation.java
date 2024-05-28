package file.navigator.services;


import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import file.navigator.resources.FileResource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClassCreation {

    public static void createClass(CompilationUnit compilationUnit, File file) {
        VoidVisitorAdapter<Void> methodVisitor = new VoidVisitorAdapter<>() {
            @Override
            public void visit(MethodDeclaration methodDeclaration, Void arg) {
                super.visit(methodDeclaration, arg);
                // Check if the method body is present
                if (methodDeclaration.getBody().isPresent()) {
                    BlockStmt body = methodDeclaration.getBody().get();
                }}};
        // Visit and modify the method declarations
        methodVisitor.visit(compilationUnit, null);
        // Save the modified compilation unit back to the file
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(compilationUnit.toString());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void updateClass(FileResource fileResource) {
        VoidVisitorAdapter<Void> methodVisitor = new VoidVisitorAdapter<>() {
            @Override
            public void visit(MethodDeclaration methodDeclaration, Void arg) {
                super.visit(methodDeclaration, arg);
                // Check if the method body is present
                if (methodDeclaration.getBody().isPresent()) {
                    BlockStmt body = methodDeclaration.getBody().get();
                }}};
        // Visit and modify the method declarations
        methodVisitor.visit(fileResource.getCu(), null);
        // Save the modified compilation unit back to the file
        try (FileWriter fileWriter = new FileWriter(fileResource.getFile())) {
            fileWriter.write(fileResource.getCu().toString());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
