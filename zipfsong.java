import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;

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

class Song {
  double quality;
  int dur;
  String name;

  public Song(double q, int d, String n) {
    quality = q; dur = d; name = n;
  }
}

public class zipfsong {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt(); int m = sc.nextInt();
    PriorityQueue<Song> pq = new PriorityQueue<>(new Comparator<Song>() {
      @Override
      public int compare(Song o1, Song o2) {
        if (o1.quality == o2.quality) {
          return o1.dur < o2.dur ? -1 : 1;
        }
        return o1.quality > o2.quality ? -1 : 1;
      }
    });

    for(int i = 1; i <= n; i++) {
      String[] ipt = sc.nextLine().split(" ");
      Double c = Double.parseDouble(ipt[0]);
      String s = ipt[1];
      pq.add(new Song(c * i, i, s));
    }
    while (m-- > 0) {
      Song sg = pq.poll();
      sc.println(sg.name);
    }
    sc.close();
  }
}
