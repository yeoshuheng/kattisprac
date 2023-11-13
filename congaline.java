import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.StringTokenizer;
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

public class congaline {
  public static void main(String[] args) throws IOException {
    FastIO sc = new FastIO();
    String[] ipt = sc.nextLine().split(" ");
    int n = Integer.parseInt(ipt[0]);
    long q = Long.parseLong(ipt[1]);
    Node front = new Node("FRONT SENTINEL");
    Node prev = front;
    for (int i = 0; i < n; i++) {
      String a = sc.next(); String b = sc.next();
      Node an = new Node(a); Node bn = new Node(b);
      an.partner = bn; bn.partner = an;
      an.next = bn; bn.prev = an;
      an.prev = prev; prev.next = an;
      prev = bn;
    }
    Node micPos = front.next;
    Node back = new Node("BACK SENTINEL");
    prev.next = back;
    back.prev = prev;

    char[] commands = sc.nextLine().toCharArray();
    for (char c : commands) {
      //System.out.println(c);
      switch (c) {
        case 'F':
          micPos = micPos.passFront();
          break;
        case 'B':
          micPos = micPos.passBack();
          break;
        case 'R':
          micPos = micPos.moveBack(front, back);
          break;
        case 'C':
          micPos = micPos.moveToPartner(front);
          break;
        case 'P':
          sc.println(micPos.shoutPartner());
      }
//      System.out.println("current micholder: " + micPos.name);
//      StringBuilder sb = new StringBuilder();
//      Node curr = front.next;
//      //while (!curr.name.equals("BACK SENTINEL")) {
//        sb.append(curr.name + " ");
//        curr = curr.next;
//      }
//      System.out.println(sb);

    }
    sc.println();
    Node curr = front.next;
    while (!curr.name.equals("BACK SENTINEL")) {
      sc.println(curr.name);
      curr = curr.next;
    }
    sc.close();
  }
}

class Node {
  Node partner;
  Node next;
  Node prev;
  String name;

  public Node(String name) {
    this.name = name;
    this.partner = this.next = this.prev = null;
  }

  public Node passBack() {
    return this.next;
  }

  public Node passFront() {
    return this.prev;
  }

  public Node moveBack(Node front, Node back) {
    if (this.equals(back.prev)) {return front.next;}
    Node tempFront = this.prev; Node tempBack = this.next;
    tempBack.prev = tempFront;
    tempFront.next = tempBack;

    Node backFront = back.prev;
    backFront.next = this;
    this.prev = backFront;
    this.next = back;
    back.prev = this;

    return tempBack;
  }

  public String shoutPartner() {
    return this.partner.name;
  }

  public Node moveToPartner(Node front) {

    Node tempFront = this.prev;
    Node tempBack = this.next;
    tempFront.next = tempBack;
    tempBack.prev = tempFront;

    Node partnerBack = partner.next;
    partner.next = this;
    this.prev = partner;
    this.next = partnerBack;
    partnerBack.prev = this;

    if (tempBack.name.equals("BACK SENTINEL")) {return front.next;}
    return tempBack;
  }
}