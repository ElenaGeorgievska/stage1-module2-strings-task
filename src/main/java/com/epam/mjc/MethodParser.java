package com.epam.mjc;

import java.util.*;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        //throw new UnsupportedOperationException("You should implement this method.");


       MethodSignature signature = new MethodSignature(signatureString);

        StringTokenizer str = new StringTokenizer(signatureString, " ");

        while (str.hasMoreTokens())
            // Getting next tokens
            str.nextToken();

        if (str.nextToken().contains("public")) {
            signature.setAccessModifier(str.nextToken());
        } else if (str.nextToken().contains("private")) {
            signature.setAccessModifier(str.nextToken());
        } else if (str.nextToken().contains("protected")) {
            signature.setAccessModifier(str.nextToken());
        } else if (str.nextToken().contains("default")) {
            signature.setAccessModifier(str.nextToken());
        }

        if (str.nextToken().contains("int")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("double")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("long")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("float")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("string")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("char")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("boolean")) {
            signature.setReturnType(str.nextToken());
        } else if (str.nextToken().contains("void")) {
            signature.setReturnType(str.nextToken());
        }


        if (signatureString.indexOf("(") > 0) {
            String methodName = signatureString.substring(Integer.parseInt(signature.getReturnType()), signatureString.indexOf("("));
            //methodName = signature.getMethodName();
            signature.setMethodName(methodName);
        }

            //if(str.nextToken().contains("(")){
            String methodParameters = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.lastIndexOf(")"));

//            if (methodParameters.length()<1){
//                signature.getArguments();
//            }
//           methodParameters = signature.getArguments().get(0).getType();
//            methodParameters = signature.getArguments().get(1).getName();









        signature.setAccessModifier(str.nextToken());
        signature.getAccessModifier();
        signature.setReturnType(str.nextToken());
        signature.getReturnType();
        signature.setMethodName(str.nextToken());
        signature.getMethodName();
        signature.getArguments().size();
        signature.getArguments().get(0).getType();
        signature.getArguments().get(1).getName();

        return signature;
    }

}
