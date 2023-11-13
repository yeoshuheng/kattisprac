import java.util.*;
import java.io.*;

public class clinic{
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

  static class patient {
    String name;
    long p;

    public patient(String name_, long t_, long s_, int k){
      name = name_;
      p = s_ - (t_ * k);
    }
  }
  public static void main(String[] args) {
    try {
      FastReader in = new FastReader();
      FastWriter out = new FastWriter();
      int n = in.nextInt(); int k = in.nextInt();
      PriorityQueue<patient> pq = new PriorityQueue<>(new Comparator<patient>() {
        @Override
        public int compare(patient o1, patient o2) {
          if (o1.p == o2.p) {
            return o1.name.compareTo(o2.name);
          }
          return o1.p < o2.p ? 1 : -1;
        }
      });
      HashSet<String> names = new HashSet<>();
      while (n-- > 0) {
        String[] ipt = in.nextLine().split(" ");
        int q = Integer.parseInt(ipt[0]);
        int t = Integer.parseInt(ipt[1]);
        switch (q) {
          case 1:
            String name = ipt[2];
            long s = Long.parseLong(ipt[3]);
            patient newp = new patient(name, t, s, k);
            names.add(name);
            pq.offer(newp);
            break;
          case 2:
            boolean found = false;
            loop1 : while (!pq.isEmpty()) {
              patient curr = pq.poll();
              if (!names.contains(curr.name)) {continue;}
              out.println(curr.name);
              found = true;
              break loop1;
            }
            if (!found) {out.println("doctor takes a break");}
            break;
          case 3:
            names.remove(ipt[2]);
            break;
        }
      }
      out.close();
    } catch (IOException e) {
      return;
    }
  }
}