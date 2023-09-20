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

        MethodSignature signature = new MethodSignature(signatureString);

        //public void log(String logString, LogLevel level, Context context)
        //public void log
        String part1 = signatureString.substring(0, signatureString.indexOf("("));
        String[] arr = part1.split(" ");

        //String logString, LogLevel level, Context context
        String methodParameters = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.lastIndexOf(")"));
        String[] arrOfStr = methodParameters.split(",");
        int argumentsNumber = arrOfStr.length;
        List<MethodSignature.Argument> argumentsList = new ArrayList<>(argumentsNumber);

        if (argumentsNumber == 1 && !methodParameters.contains(",")) {
            String[] arrOfStr2 = methodParameters.trim().split(" ");
            //(String tre)
            if (arrOfStr2.length == 2) {
                argumentsList.add(new MethodSignature.Argument(arrOfStr2[0].trim(), arrOfStr2[1].trim()));
                String[] methodName = {arr[arr.length - 1]};
                signature = new MethodSignature(methodName[0], argumentsList);
            //()
            } else {
                //parsing function with no arguments
                String[] methodName = {arr[arr.length - 1]};
                signature = new MethodSignature(methodName[0]);
            }

        } else if (argumentsNumber > 1) {
            for (int i = 0; i < arrOfStr.length; i++) {
                String[] arrOfStr1 = arrOfStr[i].trim().split(" ");
                argumentsList.add(new MethodSignature.Argument(arrOfStr1[0], arrOfStr1[1]));
                String[] methodName = {arr[arr.length - 1]};
                signature = new MethodSignature(methodName[0], argumentsList);
            }
        }

        if (signatureString.indexOf("(") > 0) {
            int k = 0;
            if (arr.length == 3) {
                signature.setAccessModifier(arr[k]);
                signature.setReturnType(arr[k + 1]);
                String[] methodName = {arr[arr.length - 1]};
            } else {
                signature.setAccessModifier(null);
                signature.setReturnType(arr[k]);
                String[] methodName = {arr[arr.length - 1]};
            }
        }

        return signature;
    }

    public static void main(String[] args) {
        MethodParser mp = new MethodParser();
        String signatureString = "public void log(String logString, LogLevel level, Context context)";
        String signatureString1 = "void log(String logString, LogLevel level, Context context)";
        String signatureString2 = "public void log()";
        String signatureString3 = "public void log(String logString)";
        String signatureString4 = "public void log(String logString, Context context)";


        mp.parseFunction(signatureString2);
        System.out.println(mp.parseFunction(signatureString2));
    }

}


