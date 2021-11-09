// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
      Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("son");
        trie.insert("hat");
        trie.insert("home");
        trie.insert("so");
         System.out.println(trie.startsWith("s"));
        System.out.println(trie.search("so"));
        trie.delete("so");
        System.out.println(trie.search("so"));
         System.out.println(trie.startsWith("o"));
        trie.delete("hat");
        System.out.println(trie.search("hat"));
    }
}

class Trie{
    
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
     public class TrieNode{
        private TrieNode[] children;
        private boolean isWord = false;
        
         public TrieNode(){
             this.children = new TrieNode[26];
             this.isWord = false;
         }
    }
    
    public void insert(String word){
        TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++)
        {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                // add a new node and refer the curr to new node
                curr.children[index] = new TrieNode();;
                curr = curr.children[index];
            }
            else
                curr =  curr.children[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
    return search(word, 1);
    }
    public boolean startsWith(String prefix) {
        return search(prefix, 2);
    }

    
    private boolean search(String word,int type){
         TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++)
        {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return type == 1? curr.isWord : true;
    }
    
    public void delete(String word){
          TrieNode curr = root;
        
        for(int i = 0; i < word.length();i++)
        {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] != null)
                curr = curr.children[index];
        }
        if(curr.isWord == true)
        {
            curr.isWord = false;
            System.out.println("Deleted Successfully");
        }
    }
}
