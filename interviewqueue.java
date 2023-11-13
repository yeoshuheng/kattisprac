import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
public class interviewqueue {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    long[] values = new long[n];

    for (int i = 0; i <n; i++) {
      values[i] = sc.nextLong();
    }
    candidateNode front = new candidateNode(Long.MIN_VALUE);
    candidateNode back = new candidateNode(Long.MIN_VALUE);
    candidateNode temp = front;
    ArrayList<candidateNode> search = new ArrayList<>();
    for (long i : values) {
      candidateNode curr = new candidateNode(i);
      temp.nxt = curr;
      curr.prev = temp;
      temp = curr;
      search.add(curr);
    }
    temp.nxt = back;
    back.prev = temp;
    int t = 0;
    Deque<StringBuilder> outpt = new LinkedList<>();
    Deque<candidateNode> leavingNow = new LinkedList<>();
    while (true) {
      //printq(front, back);
      //System.out.println(leavingNow);
      for (candidateNode curr : search) {
        if (curr.checkStrength()) {leavingNow.add(curr);}
      }
      search.clear();

      if (leavingNow.isEmpty()) {break;}
      t++;
      StringBuilder sb = new StringBuilder();
      HashSet<candidateNode> seen = new HashSet<>(leavingNow);
      while (!leavingNow.isEmpty()) {
        candidateNode leaving = leavingNow.pollFirst();
        //System.out.println("im leaving " + leaving.value);
        sb.append(leaving.value + " ");
        ArrayList<candidateNode> possiblesearch = leaving.removeMyself();
        for (candidateNode nexttosearch : possiblesearch) {
          if (!seen.contains(nexttosearch)) {search.add(nexttosearch); seen.add(nexttosearch);}
        }
      }
      //System.out.println("testing output gen " + sb);
      outpt.addLast(sb);
    }
    sc.println(t);
    while (!outpt.isEmpty()) {
      sc.println(outpt.poll());
    }
    StringBuilder sb = new StringBuilder();
    temp = front.nxt;
    while (!temp.equals(back)) {
      sb.append(temp.value + " ");
      temp = temp.nxt;
    }
    sc.println(sb);
    sc.close();
  }

  public static void printq(candidateNode front, candidateNode back) {
    StringBuilder sb = new StringBuilder();
    candidateNode temp = front.nxt;
    while (!temp.equals(back)) {
      System.out.println(temp.value);
      sb.append(temp.value + " ");
      temp = temp.nxt;
    }
    System.out.println("printing q: ");
    System.out.println(sb);
  }
}

class candidateNode {
  public long value;
  public candidateNode prev;
  public candidateNode nxt;

  public candidateNode (long val) {
    value = val;
  }

  public boolean checkStrength () {
    return (this.value < this.prev.value || this.value < this.nxt.value);
  }

  public ArrayList<candidateNode> removeMyself () {
    candidateNode prev = this.prev;
    candidateNode next = this.nxt;
    prev.nxt = next;
    next.prev = prev;
    //System.out.println("connected next: " + next.value + " with prev: " + prev.value);

    this.nxt = new candidateNode(Long.MIN_VALUE);
    this.prev = new candidateNode(Long.MIN_VALUE);

    ArrayList<candidateNode> ret = new ArrayList<>();
    if (prev.value != Long.MIN_VALUE) {
      ret.add(prev);
    }
    if (next.value != Long.MIN_VALUE) {
      ret.add(next);
    }
    return ret;
  }
}