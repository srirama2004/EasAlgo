
/*
Explanation:
Design a data structure that follows the constraints of Least Recently Used (LRU) cache.
Implement the LRUCache class:

LRUCache(int capacity): We need to initialize the LRU cache with positive size capacity.
int get(int key): Returns the value of the key if the key exists, otherwise return -1.
void put(int key,int value): Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.
*/

class Node{
    public int key,val;
    public Node next,prev;
    Node(){
        key=val=-1;
        next=prev=null;
    }
    Node(int k,int value){
        key=k;
        val=value;
        next=prev=null;
    }
}



class LRUCache {
private Map<Integer,Node>mpp;
private int cap;
private Node head;
private Node tail;
private void deleteNode(Node node){
    Node prevNode=node.prev;
    Node nextNode=node.next;
    prevNode.next=nextNode;
    nextNode.prev=prevNode;
}
private void insertAfterHead(Node node){
    Node nextNode=head.next;
    head.next=node;
    node.next=nextNode;
    node.prev=head;
    nextNode.prev=node;
}
    public LRUCache(int capacity) {
       cap=capacity;
       head=new Node();
       tail=new Node();
       mpp=new HashMap<>();
       head.next=tail;
       tail.prev=head;
    }

    public int get(int key) {
       if(!mpp.containsKey(key))
       return -1;
       Node node=mpp.get(key);
       int val=node.val;
       deleteNode(node);
       insertAfterHead(node);
       return val;

    }

    public void put(int key, int value) {
      if(mpp.containsKey(key)){
        Node node=mpp.get(key);
        node.val=value;
        deleteNode(node);
        insertAfterHead(node);
        return;
      }
      if(mpp.size()==cap){
        Node node=tail.prev;
        mpp.remove(node.key);
        deleteNode(node);
      }
      Node newNode=new Node(key,value);
      mpp.put(key,newNode);
      insertAfterHead(newNode);
    }

}
