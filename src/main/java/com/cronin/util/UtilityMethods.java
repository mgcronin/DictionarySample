package com.cronin.util;

import com.cronin.com.cronin.exception.InvalidWordException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matthewcronin on 2/6/16.
 */
public class UtilityMethods {
    static final Logger logger = Logger.getLogger(UtilityMethods.class);

    /**
     * Reads a file in line by line
     *
     * @param filename
     * @param cs
     * @throws IOException
     */
    public static List<String> readfile(String filename, Charset cs) throws IOException {

        InputStream fileInputStream = UtilityMethods.class.getClassLoader().getResourceAsStream(filename);
        if (fileInputStream == null) {
            throw new IOException("file " + filename + "not found");
        }
        InputStreamReader isr = new InputStreamReader(fileInputStream, cs);
        BufferedReader br = new BufferedReader(isr);
        List<String> stringList = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            stringList.add(line);
        }
        br.close();
        return stringList;
    }


    /**
     * Method to validate input String contains only charachters A-Z and/or a-z
     *
     * @param word
     * @throws InvalidWordException
     */
    public static void wordValidator(String word) throws InvalidWordException {
        Pattern p = Pattern.compile("^[^\\W\\d_]+$");
        Matcher m = p.matcher(word);
        if (!m.find())
            throw new InvalidWordException("Only single alpha string accepted");
    }
}
