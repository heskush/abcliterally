package practice.coding.gfg.trees.advanced.patternsearching;

import practice.language.java.util.DemonstrationUtil;

import java.util.Arrays;

// author -- hemantkumar
public class Tries {
    int totalCharcaters;
    TrieNode root;

    public Tries(int totalCharcaters) {

        this.totalCharcaters = totalCharcaters;
        this.root = new TrieNode();
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[totalCharcaters];
        boolean isEndOfWord = false;

    }

    public void insert(String s) {
        TrieNode currentRoot = this.root;
        int nLevels = s.length();
        for (int i = 0; i < nLevels; i++) {
            int charIndex = (int) s.charAt(i) - 'a';
            TrieNode[] children = currentRoot.children;
            TrieNode daughterNode = children[charIndex];
            if (daughterNode == null) {
                children[charIndex] = new TrieNode();
                daughterNode = children[charIndex];
            }
            currentRoot = daughterNode;
        }
        currentRoot.isEndOfWord = true;

    }

    public boolean search(String s) {
        TrieNode currentRoot = this.root;
        int nLevels = s.length();
        for (int i = 0; i < nLevels; i++) {
            int charIndex = (int) s.charAt(i) - 'a';
            TrieNode[] children = currentRoot.children;
            TrieNode daughterNode = children[charIndex];
            if (daughterNode == null) {
                return false;
            }
            currentRoot = daughterNode;


        }
        return currentRoot.isEndOfWord;
    }


    public void deleteKey(String s) {
        deleteKeyRecur(0, s, root);


    }

    private boolean deleteKeyRecur(int level, String word, TrieNode currentParent) {
//        Base Case: The entire word has been covered.
        long descendantCount = Arrays.stream(currentParent.children).filter(x -> x != null).count();
        if (level > word.length() - 1) {
            currentParent.isEndOfWord = false;
            return descendantCount > 0 ? false : true;
        }
        int charIndex = word.charAt(level) - 'a';
        TrieNode nextParent = currentParent.children[charIndex];
        if (nextParent == null) {
            return false;
        }
        boolean deleteCurrentParent = deleteKeyRecur(++level, word, nextParent);
        if (!deleteCurrentParent) {
            return false;
        } else {
            currentParent.children[charIndex] = null;
            return descendantCount > 1 ? false : true;


        }


    }


    public static void main(String[] args) {
        LongestMatchingPrefix.initialize(new String[]{"are", "area", "base", "cat", "cater", "basement"}).demonstrateMultiple(new String[]{"cater", "basement", "arex"});


    }


}

/*  ---------------YELLOW-------------------
 *   Coding subtleties.
 *
 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * */

class LongestMatchingPrefix {
    String[] inputKeys;
    Tries trieImplementation;

    private LongestMatchingPrefix(String[] inputKeys) {
        this.inputKeys = inputKeys;
        trieImplementation = new Tries(28);
        Arrays.stream(inputKeys).forEach(trieImplementation::insert);
    }

    public static LongestMatchingPrefix initialize(String[] inputKeys) {
        return new LongestMatchingPrefix(inputKeys);

    }

    public String execute(String key) {
        return longestPrefixRecur(key, "", "", trieImplementation.root, 0);
    }

    public void demonstrate(String key) {

        System.out.println("Max Prefix in the trie which is also a word for " + key + " is " + execute(key));

    }

    public void demonstrateMultiple(String[] keys) {
        System.out.println("LongestMatchingPrefix.demonstrateMultiple");
        Arrays.stream(keys).forEach(this::demonstrate);
        DemonstrationUtil.terminate();

    }

    public String longestPrefixRecur(String key, String previousMatch, String buffer, Tries.TrieNode parent, int level) {
        if (level > key.length() - 1) {
            return previousMatch;
        }
        int currentChar = key.charAt(level) - 'a';
        Tries.TrieNode nextParent = parent.children[currentChar];
        if (nextParent == null) {
            return previousMatch;
        }
        if (nextParent.isEndOfWord) {
            previousMatch = previousMatch + buffer + key.charAt(level);
            buffer = "";
        } else {
            buffer = buffer + key.charAt(level);
        }
        return longestPrefixRecur(key, previousMatch, buffer, nextParent, ++level);


    }

}
