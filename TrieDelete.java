class TrieNode {
	TrieNode[] child = new TrieNode[26];
	boolean end;

	public TrieNode() {
		end = false;
		for (int i = 0; i < 26; i++) {
			child[i] = null;
		}
	}
}

public class TrieDelete {
	static TrieNode root;

	public TrieDelete() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.child[index] == null) {
				current.child[index] = new TrieNode();
			}
			current = current.child[index];
		}
		current.end = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.child[index] == null) {
				return false;
			}
			current = current.child[index];
		}
		return current.end;
	}

	public boolean isEmpty(TrieNode root) {
		for (int i = 0; i < 26; i++)
			if (root.child[i] != null)
				return false;
		return true;
	}

	public TrieNode remove(TrieNode root, String key, int depth) {
		if (root == null)
			return null;

		// If last character of key is being processed
		if (depth == key.length()) {
			if (root.end)
				root.end = false;

			// If given is not prefix of any other word
			if (isEmpty(root)) {
				root = null;
			}

			return root;
		}
		int index = key.charAt(depth) - 'a';
		root.child[index] = remove(root.child[index], key, depth + 1);
		if (isEmpty(root) && root.end == false) {
			root = null;
		}
		return root;
	}

	public static void main(String[] args) {
		TrieDelete t = new TrieDelete();
		t.insert("hello");
		t.insert("catch");
		t.insert("cat");
		System.out.println(t.search("catch"));
		t.remove(TrieDelete.root,"catch",0);
		System.out.println(t.search("catch"));
	}
}