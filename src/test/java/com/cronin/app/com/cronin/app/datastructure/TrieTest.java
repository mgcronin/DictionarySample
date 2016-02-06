package com.cronin.app.com.cronin.app.datastructure;

import com.cronin.app.WordLookupApp;
import com.cronin.com.cronin.datastructure.Trie;
import com.cronin.com.cronin.exception.InvalidWordException;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by matthewcronin on 2/6/16.
 */
public class TrieTest {

    static final Logger logger = Logger.getLogger(TrieTest.class);


    Trie dict;

    @Before
    public void setUp() {
        // one-time initialization code
        logger.info("@Before - setUp");
        List<String> wordList = new ArrayList<String>();
        wordList.add("tiger");
        wordList.add("shark");
        wordList.add("easter");
        wordList.add("east");
        dict = new Trie();


        for (String word : wordList) {
            dict.insert(word);
        }
    }


    @Test(expected = NullPointerException.class)
    public void testInsertNull() {
        logger.info("@Test - testInsertNull");
        Trie testTrie = new Trie();
        testTrie.insert(null);
    }

    @Test
    public void testSearchWordFound() throws InvalidWordException {
        logger.info("@Test - testSearchWordFound");
        String word = dict.search("tiger");
        assertEquals(word, "tiger");

    }

    @Test
    public void testSearchWordNotFound() {
        logger.info("@Test - testSearchWordNotFound");
        String word = dict.search("buffalo");
        assertNotEquals(word, "buffalo");

    }

    @Test
    public void testSuggestionGiven() throws InvalidWordException {
        logger.info("@Test - testSuggestionGiven");
        String word = dict.search("eastz");
        assertEquals(word, "east");

    }
}
