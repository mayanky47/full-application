package file.navigator.testing;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.GenericListVisitorAdapter;
import file.navigator.resources.FileResource;
import project.navigator.resources.ProjectStructure;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static file.navigator.FileResourceRetriever.retrieverFileResource;
import static file.navigator.services.MethodCreation.*;
import static file.navigator.utility.PackageHelper.sourceFileBuilder;
import static project.navigator.ProjectStructureRetriever.retrieveRestProject;

public class MainClass {

    public static void main(String[] args) {

        Modifier.Keyword PUBLIC = Modifier.Keyword.PUBLIC;
        Modifier.Keyword PROTECTED = Modifier.Keyword.PROTECTED;
        Modifier.Keyword PRIVATE = Modifier.Keyword.PRIVATE;
        Modifier.Keyword STATIC = Modifier.Keyword.STATIC;
        Modifier.Keyword FINAL = Modifier.Keyword.FINAL;
        Modifier.Keyword ABSTRACT = Modifier.Keyword.ABSTRACT;


        String path = "C:\\Users\\Mayank\\Desktop\\testingData\\artifact-project";


//        BlockStmt body = new BlockStmt();
//
//        MethodCallExpr methodCallExpr = new MethodCallExpr();
//        methodCallExpr.setName("getName");
//        body.addStatement(methodCallExpr);
//
//        ProjectStructure p = retrieveRestProject(path);
//
//        assert p != null;
//        Path path2 = Paths.get(p.getJavaClassPath().toUri()).resolve(p.getJavaClassPath()).resolve("controller").resolve(p.getControllerClasses().get(0));
//        FileResource f = retrieverFileResource(p,path2.toString());


//
//        List<FieldDeclaration> fields = f.getCu().accept(new FieldVisitor(), null);
//        fields.forEach(field -> System.out.println(field));
        // Print the BlockStmt



//        String a = "https://local.principal.com:8080/hello//{ab}/hi?{abc}";
//                String b = "ram";
//                int c = 5;
//        String url = UriComponentsBuilder.fromHttpUrl(a).buildAndExpand(b,c).toUriString();
//        System.out.println(url);

        MethodDeclaration method = createMethod("String", "protected", "demoMethod", "Ram ram", "return \"ram\";");
        AnnotationExpr annotation = new MarkerAnnotationExpr("GetMapping");
        Name name = new Name("GetMapping");
        Expression e = new StringLiteralExpr("/hello");
        AnnotationExpr annotationExpr = new SingleMemberAnnotationExpr(name,e);
//        annotation.setName("RestController");
//        annotation.set
        method.addAnnotation(annotationExpr);
        System.out.println(method.toString());
        MethodDeclaration m =createMethodWithAnnotation("String", "protected", "demoMethod", "Ram ram", "return \"ram\";", "GetMapping", "/hello");
        System.out.println(m);

    }

    private static class FieldVisitor extends GenericListVisitorAdapter<FieldDeclaration, Void> {
        @Override
        public List<FieldDeclaration> visit(FieldDeclaration fd, Void arg) {
            super.visit(fd, arg);
            return List.of(fd); // Return the field declaration
        }
}}
