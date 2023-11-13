import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;

public class prob99{
  static class FastReader{
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
      br=new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
      while(st==null || !st.hasMoreTokens()){
        try {
          st=new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
    int nextInt(){
      return Integer.parseInt(next());
    }
    long nextLong(){
      return Long.parseLong(next());
    }
    double nextDouble(){
      return Double.parseDouble(next());
    }
    String nextLine(){
      String str="";
      try {
        str=br.readLine().trim();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return str;
    }
  }
  static class FastWriter {
    private final BufferedWriter bw;

    public FastWriter() {
      this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public void print(Object object) throws IOException {
      bw.append("" + object);
    }

    public void println(Object object) throws IOException {
      print(object);
      bw.append("\n");
    }

    public void close() throws IOException {
      bw.close();
    }
  }
  public static void main(String[] args) {
    try {
      FastReader in=new FastReader();
      FastWriter out = new FastWriter();
      long n = in.nextLong(); long q = in.nextLong();
      TreeMap<Long, Long> questions = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        long difficulty = in.nextLong();
        questions.put(difficulty, questions.getOrDefault(difficulty, (long) 0) + 1);
      }
      while (q-- > 0) {
        long a = in.nextLong(); long b = in.nextLong();
        Long k;
        if (a == 1) {
          k = questions.higherKey(b);
        } else {
          k = questions.floorKey(b);
        }
        if (k == null) {
          out.println(-1);
          continue;
        }
        long updated = questions.get(k) - 1;
        out.println(k);
        if (updated > 0) {
          questions.put(k, updated);
        } else {
          questions.remove(k);
        }
      }
      out.close();
    } catch (Exception e) {
      return;
    }
  }
}
