import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class delimitersoup {
  public static void main(String[] args) throws IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> leftclose = new Stack<>();
    int n = Integer.parseInt(sc.readLine());
    HashMap<Character, Character> rights = new HashMap<>();
    rights.put(')', '('); rights.put('}', '{'); rights.put(']', '[');
    HashSet<Character> validLeft = new HashSet<>();
    validLeft.add('{'); validLeft.add('['); validLeft.add('(');
    String inpt = sc.readLine();
    for (int i = 0; i < n; i++) {
      Character curr = inpt.charAt(i);
      if (rights.containsKey(curr)) {
        if (leftclose.empty() || !leftclose.peek().equals(rights.get(curr))) {
          System.out.println(curr + " " + i);
          return;
        } else {
          leftclose.pop();
        }
      } else if (validLeft.contains(curr)) {
        leftclose.push(curr);
      }
    }
    System.out.println("ok so far");
  }
}
