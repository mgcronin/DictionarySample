package com.cronin.app;

import com.cronin.com.cronin.datastructure.Trie;
import com.cronin.com.cronin.exception.InvalidWordException;
import com.cronin.util.UtilityMethods;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WordLookupApp
 * Application will look up a word in standard US dictionary and return
 * the word if found or offer suggestions based on possible matches
 */
public class WordLookupApp {

    static final Logger logger = Logger.getLogger(WordLookupApp.class);

    public static final String dictionary = "US.dic";
    private Trie dict;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word for dictionary lookup (valid charachters [a-z A-Z]): ");

        String word = scanner.nextLine();
        scanner.close();
        try {
            WordLookupApp app = new WordLookupApp(WordLookupApp.dictionary);

            //search for inputString;
            String searchResult = null;

            searchResult = app.searchWord(word);

            if (searchResult.equals(word))
                System.out.println("input: " + word + " was found in the dictionary ");
            else {
                System.out.println("input: " + word + " was not found ");
                //offer suggestion if possible
                if (searchResult != null && !searchResult.equals(""))
                    System.out.println("Possible suggestion of: " + searchResult);
            }
        } catch (IOException ie) {
            logger.error("Error reading dictionary file", ie);
        } catch (InvalidWordException iwe) {
            logger.error(iwe.getMessage(), iwe);
        }


    }

    /**
     * Constructor that will use default dictionary
     *
     * @throws IOException
     */
    public WordLookupApp() throws IOException {
        initDictionary(WordLookupApp.dictionary);
    }

    /**
     * Constructor that will take custom dictionary file
     *
     * @param dictionaryFile
     * @throws IOException
     */
    public WordLookupApp(String dictionaryFile) throws IOException {
        initDictionary(dictionaryFile);

    }

    /**
     * Search for word in Trie structure
     *
     * @param word
     * @return
     * @throws InvalidWordException
     */
    public String searchWord(String word) throws InvalidWordException {
        //validate String to ensure it is alpha and does not have spaces

        UtilityMethods.wordValidator(word);

        //search for inputString;
        String searchResult = this.dict.search(word);
        return searchResult;
    }

    /**
     * Initialize Trie Structure from file
     *
     * @param dictionaryFile
     * @throws IOException
     */
    private void initDictionary(String dictionaryFile) throws IOException {

        this.dict = new Trie();
        //read dictionary file
        List<String> wordList = new ArrayList<String>();
        wordList = UtilityMethods.readfile(dictionaryFile, StandardCharsets.UTF_8);

        //initialize our Trie data structure and add dictionary

        for (String word : wordList) {
            this.dict.insert(word);
        }

    }

}
