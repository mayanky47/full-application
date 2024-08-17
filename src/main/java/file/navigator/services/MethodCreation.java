package file.navigator.services;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MethodCreation {

    static Modifier.Keyword PUBLIC = Modifier.Keyword.PUBLIC;
    static Modifier.Keyword PROTECTED = Modifier.Keyword.PROTECTED;
    static Modifier.Keyword PRIVATE = Modifier.Keyword.PRIVATE;
    static Modifier.Keyword STATIC = Modifier.Keyword.STATIC;
    static Modifier.Keyword FINAL = Modifier.Keyword.FINAL;
    static Modifier.Keyword ABSTRACT = Modifier.Keyword.ABSTRACT;


    public static MethodDeclaration createMethodWithAnnotation(String type, String modifier, String name, String paramter_str,String body, String annotatinName_str, String annotationValue_str){
        MethodDeclaration methodDeclaration = createMethod(type,modifier,name,paramter_str,body);
        Name annotationName = new Name(annotatinName_str);
        Expression annotationValue = new StringLiteralExpr(annotationValue_str);

        AnnotationExpr annotationExpr = new SingleMemberAnnotationExpr(annotationName,annotationValue);
        methodDeclaration.addAnnotation(annotationExpr);
        return methodDeclaration;
    }

    public static MethodDeclaration createMethod(String type, String modifier, String name, String paramter_str,String body){
        MethodDeclaration methodDeclaration = new MethodDeclaration();

        methodDeclaration.setName(name);
        methodDeclaration.setType(type);
        methodDeclaration.setModifiers(getModifiers().get(modifier));
        if (paramter_str != null && !paramter_str.isEmpty()) {
            methodDeclaration.setParameters(getParameters(paramter_str));
        }

        methodDeclaration.setBody(createBlockStmt(body));

        return methodDeclaration;
    }


    private static HashMap<String, Modifier.Keyword> getModifiers(){
        HashMap<String, Modifier.Keyword> modifiers = new HashMap<>();
        modifiers.put("public", PUBLIC);
        modifiers.put("protected", PROTECTED);
        modifiers.put("private", PRIVATE);
        modifiers.put("static", STATIC);
        modifiers.put("final", FINAL);
        modifiers.put("abstract", ABSTRACT);
        return modifiers;
    }

    private static  NodeList<Parameter> getParameters(String params){
        String[] pairs = params.split(",");
        Map<String, String> map = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split(" ");
            if (keyValue.length == 2) {
                map.put(keyValue[0], keyValue[1]);
            } else {
                System.out.println("Invalid input format: " + pair);
            }
        }
        NodeList<Parameter> nodeListOfParam = new NodeList<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            Parameter p = new Parameter();
            p.setType(entry.getKey());
            p.setName(entry.getValue());
            nodeListOfParam.add(p);
        }
        return nodeListOfParam;
    }

    public static BlockStmt createBlockStmt(String body){
        List<String> lines = List.of(body.split("\\n"));
        BlockStmt blockStmt = new BlockStmt();
        JavaParser parser = new JavaParser();

        for (String line : lines) {
            // Parse each line to a Statement
            Statement statement = parser.parseStatement(line).getResult().orElseThrow(() ->
                    new IllegalArgumentException("Invalid statement: " + line));
            // Add the statement to the block
            blockStmt.addStatement(statement);
        }

        return blockStmt;
    }
}


