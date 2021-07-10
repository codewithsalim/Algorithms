class Trie{
  private Node root;
  
  public Trie(){
    root = new Node('*');
  }
  
  //insert a new word into trie
  public void insert(String word){
    Node curr = root;
    for (int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null ){
        curr.children[c - 'a'] = new Node(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }
  
  //returns if the word is in the trie
  public boolean search(String word){
    Node node = getNode(word);
    return node != null && node.isWord = true;
  }
  
  //returns if there is any word in the trie that starts with that prefix
  public boolean startsWith(String prefix){
    return getNode(prefix) != null;
  }
  
  private Node getNode(String word){
    Node curr = root;
    for (int i = 0; i < word.length(); i++ ){
      char c = word.charAt(i);
      if ( curr.children[c - 'a' ] == null ){
        return null;
      }
      curr = curr.children[c - 'a'];
    }
    return curr;
  }
  
  class Node{
    public char c;
    public boolean isWord;
    public Node[] children;
    
    Node(char c){
      this.c = c;
      isWord = false;
      children = new Node[26];
    }
    
    
  }
  

}
