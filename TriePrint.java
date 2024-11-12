class TrieNode{
    TrieNode[] child=new TrieNode[26];
    boolean end;
    public TrieNode(){
        end=false;
        for(int i=0;i<26;i++){
            child[i]=null;
        }
    }
}
public class TriePrint{
    static String res="";
    static TrieNode root;
    public TriePrint(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode current=root;
        for (int i = 0; i < word.length(); i++) {
            int index=word.charAt(i)-'a';
            if(current.child[index]==null){
                current.child[index]=new TrieNode();
            }
            current=current.child[index];
        }
        current.end=true;
    }

    private void dfs(TrieNode node,StringBuilder s) {
        if (node == null) {
            return;
        }
        if (node.end) {
            System.out.println(s.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                s.append((char) (i + 'a'));
                dfs(node.child[i],s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        TriePrint t=new TriePrint();
        t.insert("hello");
        t.insert("catch");
        t.insert("cat");
        t.dfs(TriePrint.root,new StringBuilder());
    }
}