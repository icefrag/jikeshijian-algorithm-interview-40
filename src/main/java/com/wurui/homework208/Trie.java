package com.wurui.homework208;

/**
 * @description:
 * @author: wurui
 * @create: 2019-04-28 07:32
 **/
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(currentNode.children[c - 'a'] != null){
                currentNode = currentNode.children[c - 'a'];
            }else{
                TrieNode temp = new TrieNode();
                currentNode.children[c - 'a'] = temp;
                currentNode = temp;
            }
            if (i == word.length() - 1){
                currentNode.isEndOfWord = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (currentNode.children[c - 'a'] == null){
                return false;
            }else{
                currentNode = currentNode.children[c - 'a'];
            }

            if (i == word.length() - 1){
                return currentNode.isEndOfWord;
            }
        }

        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (currentNode.children[c - 'a'] == null){
                return false;
            }else{
                currentNode = currentNode.children[c - 'a'];
            }
        }
        return true;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;

        TrieNode() {
            isEndOfWord = false;
            for (TrieNode child : children) {
                child = null;
            }
        }
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
