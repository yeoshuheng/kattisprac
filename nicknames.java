import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class FastIO extends PrintWriter {
  BufferedReader br;
  StringTokenizer st;
  public FastIO() {
    super(new BufferedOutputStream(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
  }
  String next() {
    while (st == null || ! st.hasMoreElements()) {
      try { st = new StringTokenizer(br.readLine()); }
      catch (IOException  e) { e.printStackTrace(); }
    }
    return st.nextToken();
  }
  int nextInt() { return Integer.parseInt(next()); }
  long nextLong() { return Long.parseLong(next()); }
  double nextDouble() { return Double.parseDouble(next()); }
  String nextLine() {
    String str = "";
    try { str = br.readLine(); }
    catch (IOException e) { e.printStackTrace(); }
    return str;
  }
}
public class nicknames {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    Trie names = new Trie();
    for (int i = 0; i < n; i++) {
      String name = sc.nextLine();
      names.insert(name);
    }
    int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      String name = sc.nextLine();
      sc.println(names.getCount(name));
    }
    sc.close();
  }
}


class TrieNode {
  Character content;
  HashMap<Character, TrieNode> next = new HashMap<>();

  int count = 0;

  boolean endWord = false;
}

class Trie {
  private static TrieNode root = new TrieNode();

  public static void insert (String word) {
    TrieNode curr = root;
    for (Character c : word.toCharArray()) {
      if (!curr.next.containsKey(c)) {
        curr.next.put(c, new TrieNode());
      }
      curr = curr.next.get(c);
      curr.count++;
    }
    curr.endWord = true;
  }

  public static boolean find(String word) {
    TrieNode curr = root;
    for (Character c : word.toCharArray()) {
      if (!curr.next.containsKey(c)) {
        return false;
      }
      curr = curr.next.get(c);
    }
    //return curr.endWord;
    // We dont need to confirm if word is in subtree for this purpose
    //  -> we just need to check no. of nicknames
    return true;
  }

  public static int getCount(String word) {
    TrieNode curr = root;
    for (Character c : word.toCharArray()) {
      if (!curr.next.containsKey(c)) {
        return 0;
      }
      curr = curr.next.get(c);
    }
    return curr.count;
  }
}