
/*
Explanation:
Implement "TRIE” data structure from scratch with the following functions.

Trie(): Initialize the object of this “TRIE” data structure.
insert(“WORD”): Insert the string “WORD” into this “TRIE” data structure.
countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in this “TRIE”.
countWordsStartingWith(“PREFIX”): Return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.
erase(“WORD”): Delete one occurrence of the string “WORD” from the “TRIE”.
*/

class Node{
    private Node[] links;
    private int cntEndWith;
    private int cntPrefix;
    public Node(){
        links=new Node[26];
        cntEndWith=0;
        cntPrefix=0;
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public void increaseEnd(){
        cntEndWith++;
    }
    public void increasePrefix(){
        cntPrefix++;
    }
    public void deleteEnd(){
        cntEndWith--;
    }
    public void reducePrefix(){
        cntPrefix--;
    }
    public int getEnd(){
        return cntEndWith;
    }
    public int getPrefix(){
        return cntPrefix;
    }
}

class Trie {
    private Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node=node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i)))
            node=node.get(word.charAt(i));
            else
            return 0;
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i)))
            node=node.get(word.charAt(i));
            else
            return 0;
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node=node.get(word.charAt(i));
                node.reducePrefix();
            }
            else
            return;
        }
        node.deleteEnd();
    }
}
