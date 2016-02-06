package com.cronin.app;


import com.cronin.com.cronin.exception.InvalidWordException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Unit test for simple WordLookupApp.
 */
public class WordLookupAppTest {

    static final Logger logger = Logger.getLogger(WordLookupAppTest.class);

    private WordLookupApp app;

    @Before
    public void setUp() {
        // one-time initialization code
        logger.info("@Before - setUp");
        try {
            app = new WordLookupApp();
        } catch (IOException e) {
            logger.error(e);
        }

    }


    @Test(expected = InvalidWordException.class)
    public void testInvalidWordException() throws InvalidWordException {
        logger.info("@Test - testInvalidWordException");
        app.searchWord("Carolina Panthers");
    }

    @Test
    public void testSearchWordFound() throws InvalidWordException {
        logger.info("@Test - testSearchWordFound");
        String word = app.searchWord("football");
        assertEquals(word, "football");

    }

    @Test
    public void testSearchWordNotFound() throws InvalidWordException {
        logger.info("@Test - testSearchWordNotFound");
        String word = app.searchWord("IAMNOTAWORD");
        assertNotEquals(word, "IAMNOTAWORD");

    }
}
