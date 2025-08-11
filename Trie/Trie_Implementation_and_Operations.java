
/*
Explanation:
Implement the Trie class:
Trie(): Initializes the trie object.
void insert (String word): Inserts the string word into the trie.
boolean search (String word): Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith (String prefix): Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
*/

class Node{
    Node[]links=new Node[26];
    boolean flag=false;
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    void put(char ch,Node node){
        links[ch-'a']=node;
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
class Trie {
    private Node root;
    Trie() {
        root=new Node();
    }

    void insert(String word) {
        Node node=root;
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setEnd();
    }

    boolean search(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))
            return false;
             node=node.get(ch);
        }
       return node.isEnd();
    }

    boolean startsWith(String prefix) {
          Node node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch))
            return false;
             node=node.get(ch);
        }
       return true;
    }
}

