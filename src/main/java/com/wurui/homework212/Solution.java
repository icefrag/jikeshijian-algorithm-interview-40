package com.wurui.homework212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。  单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * @author: wurui
 * @create: 2019-06-03 11:43
 **/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0)return new ArrayList<>(1);
        Trie trie = getTrie(words,board.length * board[0].length);
        Set<String> set = new HashSet<>();

        for (int y = 0; y < board.length; y ++){
            for (int x = 0; x < board[y].length; x ++){
                find(words,board,trie,y,x,3,new StringBuilder(),set,new HashSet<String>());
                find(words,board,trie,y,x,2,new StringBuilder(),set,new HashSet<String>());
            }
        }
        return new ArrayList<>(set);
    }

    private Trie getTrie(String[] words, int length) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > length)continue;
            trie.insert(word);
        }
        return trie;
    }

    /**
     * @param board
     * @param trie
     * @param y
     * @param x
     * @param direct 0-上 1-下 2-左 3-右
     */
    private void find(String[] words,char[][] board, Trie trie, int y, int x, int direct, StringBuilder sb, Set<String> set,Set<String> has) {
        String index = x + "," + y;
        if (has.contains( index))return;

        has.add(index);
        sb.append(board[y][x]);

        if (trie.search(sb.toString())){
            set.add(sb.toString());
        }

        if (!trie.startsWith(sb.toString())){
            sb.deleteCharAt(sb.length() - 1);
            has.remove(index);
            return;
        }

        // 上
        if (direct != 1 && y - 1 >= 0)
            find(words,board, trie, y - 1, x, 0, sb,set,has);
        // 下
        if (direct != 0 && y + 1 <= board.length - 1)
            find(words,board, trie, y + 1, x, 1, sb,set,has);
        // 左
        if (direct != 3 && x - 1 >= 0)
            find(words,board, trie, y, x - 1, 2, sb,set,has);
        // 右
        if (direct != 2 && x + 1 <= board[0].length - 1)
            find(words,board, trie, y, x + 1, 3, sb,set,has);

        // 4个方向都没有的话,清空这个值.
        sb.deleteCharAt(sb.length() - 1);
        has.remove(index);
    }

    static class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        public boolean isNullTrie(){
            for (int i = 0; i < root.children.length; i++) {
                TrieNode child = root.children[i];
                if (child != null) return false;
            }
            return true;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (currentNode.children[c - 'a'] != null) {
                    currentNode = currentNode.children[c - 'a'];
                } else {
                    TrieNode temp = new TrieNode();
                    currentNode.children[c - 'a'] = temp;
                    currentNode = temp;
                }
                if (i == word.length() - 1) {
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
                if (currentNode.children[c - 'a'] == null) {
                    return false;
                } else {
                    currentNode = currentNode.children[c - 'a'];
                }

                if (i == word.length() - 1) {
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
                if (currentNode.children[c - 'a'] == null) {
                    return false;
                } else {
                    currentNode = currentNode.children[c - 'a'];
                }
            }
            return true;
        }

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
        Solution solution = new Solution();
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
//        System.out.println(solution.findWords(board,words));

        String[] words2 = {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"};
        char[][] board2 = {
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'},
        };

        System.out.println(solution.findWords(board2,words2));
    }
}
