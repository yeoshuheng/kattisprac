import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

class Node {
  public String cc;
  public Node next;
  public Node end;
  public Node(String word) {
    this.cc = word;
    end = this;
    next = null;
  }
}

public class joinstrings {

  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(sc.readLine());
    Node[] stk = new Node[n];
    for (int i = 0; i < n; i++) {
      String s = sc.readLine();
      Node curr = new Node(s);
      stk[i] = curr;
    }
    int fin = 0;
    for (int i = 0; i < n - 1; i++) {
      String[] istr = sc.readLine().split(" ");
      int a = Integer.parseInt(istr[0]) - 1; int b = Integer.parseInt(istr[1]) - 1;
      Node as = stk[a];
      Node bs = stk[b];
      as.end.next = bs;
      as.end = bs.end;
      if (i == n - 2) {fin = a;}
    }
    Node ccc = stk[fin];
    StringBuilder sb = new StringBuilder();
    while (ccc != null) {
      sb.append(ccc.cc);
      ccc = ccc.next;
    }
    System.out.println(sb);
  }
}
