package com.cronin.com.cronin.datastructure;

import java.util.HashMap;

/**
 * Created by matthewcronin on 2/6/16.
 */
public class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children;
    private boolean bIsEnd;

    public TrieNode(char c) {
        value = c;
        children = new HashMap<Character, TrieNode>();
        bIsEnd = false;

    }

    /**
     * @return
     */
    public char getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * @return
     */
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @param children
     */
    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    /**
     * @return
     */
    public boolean isbIsEnd() {
        return bIsEnd;
    }

    /**
     * @param bIsEnd
     */
    public void setbIsEnd(boolean bIsEnd) {
        this.bIsEnd = bIsEnd;
    }
}
