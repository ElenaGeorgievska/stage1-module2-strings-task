package com.epam.mjc;

import java.util.*;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */


    private List<String> allTokens = List.of("q", "w", "e", "r", "t", "y", "u",
            "i", "o", "p", "a", "s", "d", "f", "g", "h",
            "j", "k", "l", "z", "x", "c", "v", "b", "n",
            "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", " ", ".");

    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        List<String> result = new ArrayList<>();

        //start solution
        StringTokenizer st1 = new StringTokenizer(
                source, delimiters.toString());
        while (st1.hasMoreTokens())
            // Getting next tokens
            result.add(st1.nextToken());

        return result;
    }

    public static void main(String[] args){
        String source = "Hello Geeks. Elena, How are you";
        Set<String> delimiters = new HashSet<String>();
        delimiters.add(",");
        delimiters.add(" ");
        delimiters.add(".");

        StringSplitter ss = new StringSplitter();
        ss.splitByDelimiters(source, delimiters);
        System.out.println(ss.splitByDelimiters(source, delimiters));
    }

}



