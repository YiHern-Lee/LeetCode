class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String key, int type) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            currNode = currNode.getNextOrInsert(key.charAt(i) - 'A');
        }
        currNode.markEnd();
    }

    boolean query(String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length() && currNode != null; i++) {
            currNode = currNode.getNext(key.charAt(i) - 'A');
        }
        return currNode == null ? false : currNode.isWord;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;

    TrieNode getNextOrInsert(int id) {
        return children[id] == null ? insert(id) : children[id];
    }

    TrieNode getNext(int id) {
        return children[id];
    }

    TrieNode insert(int id) {
        return children[id] = new TrieNode();
    }

    void markEnd() {
        this.isWord = true;
    }
}