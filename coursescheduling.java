import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeMap;

public class coursescheduling {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    String[] ipt = sc.readLine().split(" ");
    int n = Integer.parseInt(ipt[0]);
    TreeMap<String, HashSet<String>> cseMap = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      ipt = sc.readLine().split(" ");
      String name = ipt[0] + ipt[1];
      String cse = ipt[2];
      if (!cseMap.containsKey(cse)) {
        cseMap.put(cse, new HashSet<>());
      }
      cseMap.get(cse).add(name);
    }
    for (String cse : cseMap.keySet()) {
      System.out.println(cse + " " + cseMap.get(cse).size());
    }
  }
}
