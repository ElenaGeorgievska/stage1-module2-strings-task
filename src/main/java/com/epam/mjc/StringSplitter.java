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
        //throw new UnsupportedOperationException("You should implement this method.");
        //List<String> result = new ArrayList<>();
        StringBuilder all = new StringBuilder();
        List<String> expectedResult = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String current = "";
        String source1 = "Hello Geeks. Elena, How are you";
        Set<String> delimiters1 = new HashSet<String>();
        delimiters1.add(",");
        delimiters1.add(" ");
        delimiters1.add(".");
        //[",", " ", "."];

        //start solution
        StringTokenizer st1 = new StringTokenizer(
                source, delimiters.toString());
        while (st1.hasMoreTokens())
            // Getting next tokens
            result.add(st1.nextToken());

        return result;


    }

}



