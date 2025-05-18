class Trie {

    char ch;
    Map<Character,Trie> nodes;
    boolean isEndNode;

    public Trie() {
        this.nodes=new HashMap<>();
        this.isEndNode=false;
    }
    
    public void insert(String word) {
        if(null == word) return;
        insertIntoTrie(this,word,0,word.length()-1);
    }

    private void insertIntoTrie(Trie trie,String word, int s, int e){
        if(s>e || null == word){
            return;
        }
        Map<Character,Trie> nodes = trie.nodes;
        if(nodes.get(word.charAt(s))!=null){
            if(s==e) nodes.get(word.charAt(s)).isEndNode = true;
            insertIntoTrie(nodes.get(word.charAt(s)),word,s+1,e);
        }else{
            Trie newTrie = new Trie();
            newTrie.ch = word.charAt(s);
            newTrie.nodes = new HashMap<>();
            if(s==e) newTrie.isEndNode = true;
            trie.nodes.put(newTrie.ch,newTrie);
            insertIntoTrie(newTrie,word,s+1,e);
        }
    }
    
    public boolean search(String word) {
        return searchInTrie(this,word,0,word.length()-1);
    }

    private boolean searchInTrie(Trie trie, String word, int s, int e){
        if(s>e) return false;
        if(s==e) {
            Trie temp = trie.nodes.get(word.charAt(s));
            if(null != temp) {
                return temp.isEndNode;
            }
            return false;
        }
        if(null == trie.nodes.get(word.charAt(s))) return false;
        return searchInTrie(trie.nodes.get(word.charAt(s)),word,s+1,e);
    }
    
    public boolean startsWith(String word) {
        return searchStartWithInTrie(this,word,0,word.length()-1);
    }

    private boolean searchStartWithInTrie(Trie trie, String word, int s, int e){
        if(s>e) return true;
        if(null == trie.nodes.get(word.charAt(s))) return false;
        return searchStartWithInTrie(trie.nodes.get(word.charAt(s)),word,s+1,e);
    }
}