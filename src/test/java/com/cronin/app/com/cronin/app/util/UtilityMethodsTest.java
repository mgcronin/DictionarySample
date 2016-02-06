package com.cronin.app.com.cronin.app.util;

import com.cronin.app.WordLookupApp;
import com.cronin.com.cronin.exception.InvalidWordException;
import com.cronin.util.UtilityMethods;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple WordLookupApp.
 */
public class UtilityMethodsTest {

    static final Logger logger = Logger.getLogger(UtilityMethodsTest.class);


    @Test(expected = IOException.class)
    public void testIOException() throws IOException {
        logger.info("@Test - testIOException");
        UtilityMethods.readfile("none", StandardCharsets.UTF_8);
    }

    @Test
    public void testReadfile() throws IOException {
        logger.info("@Test - testReadfile");
        List<String> dictionary = UtilityMethods.readfile("US.dic", StandardCharsets.UTF_8);
        assertTrue(!dictionary.isEmpty());

    }

    @Test(expected = InvalidWordException.class)
    public void testWordValidatorForSpaces() throws InvalidWordException {
        logger.info("@Test - testWordValidatorForSpaces");
        UtilityMethods.wordValidator("Words with Spaces");


    }

    @Test(expected = InvalidWordException.class)
    public void testWordValidatorForNumeric() throws InvalidWordException {
        logger.info("@Test - testWordValidatorForNumeric");
        UtilityMethods.wordValidator("3333");


    }

    @Test(expected = InvalidWordException.class)
    public void testWordValidatorForSpecialChars() throws InvalidWordException {
        logger.info("@Test - testWordValidatorForSpecialChars");
        UtilityMethods.wordValidator("[/*ger");


    }

    @Test()
    public void testWordValidator() throws InvalidWordException {
        logger.info("@Test - testWordValidator");
        UtilityMethods.wordValidator("test");
        assertTrue(true);

    }
}
