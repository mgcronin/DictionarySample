package com.cronin.com.cronin.datastructure;

import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Created by matthewcronin on 2/6/16.
 */
public class Trie {
    static final Logger logger = Logger.getLogger(Trie.class);

    private TrieNode root;

    public Trie() {
        root = new TrieNode((char) 0);
    }

    /**
     * Method to insert new word to trie
     *
     * @param word
     */
    public void insert(String word) {

        //length of word
        int length = word.length();

        //reference to crawl through trie
        TrieNode crawl = root;

        for (int i = 0; i < length; i++) {
            HashMap<Character, TrieNode> child = crawl.getChildren();
            if (child.containsKey(word.charAt(i))) {
                crawl = child.get(word.charAt(i));
            } else {
                TrieNode tempTrieNode = new TrieNode(word.charAt(i));
                child.put(word.charAt(i), tempTrieNode);
                crawl = tempTrieNode;
            }
        }

        crawl.setbIsEnd(true);

    }

    /**
     * Method to search trie for input string
     *
     * @param input
     * @return
     */
    public String search(String input) {

        //hold result
        String result = new String();

        TrieNode crawl = root;
        int length = input.length();
        int prevMatch = 0;

        for (int level = 0; level < length; level++) {
            char ch = input.charAt(level);

            if (crawl.getChildren().containsKey(ch)) {

                result += ch;
                crawl = crawl.getChildren().get(ch);
                if (crawl.isbIsEnd()) {
                    prevMatch = level + 1;
                }

            } else {
                break;
            }
        }

        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if (!crawl.isbIsEnd())
            return result.substring(0, prevMatch);
        else
            return result;
    }
}
