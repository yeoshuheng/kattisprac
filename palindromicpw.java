import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.TreeSet;

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
# find lower and upper palindrome for 2 digits at index 2,3
  def find_2_digits_palindrome(n):
  lower = n
  while lower % 10 != lower//10:
  lower -= 1
  if lower == 0:
  lower = "00"
  upper = n
  while upper % 10 != upper//10:
  upper += 1
  return str(lower), str(upper)


  def print_result(num1, num2, num):
  if abs(num1 - int(num)) < abs(num2 - int(num)):
  print(num1)
  elif abs(num1 - int(num)) > abs(num2 - int(num)):
  print(num2)
  elif num1 < num2:
  print(num1)
  else:
  print(num2)


  line = int(input())
  for i in range(line):
  num = input()

  # if number at index 2,3 are 99 or 00, increment by 1 or decrement by 1
  if int(num[2:4]) == 99:
  front = str(int(num[:3]) + 1)
  num1 = int(front + front[::-1])
  num2 = int(num[:3] + num[2::-1])
  print_result(num1, num2, num)
  elif int(num[2:4]) == 00:
  front = str(int(num[:3]) - 1)
  num1 = int(front + front[::-1])
  num2 = int(num[:3] + num[2::-1])
  print_result(num1, num2, num)

  # else find lower and upper palindromic number for number at index 2,3
  # then compare
  else:
  lower, upper = find_2_digits_palindrome(int(num[2:4]))
  num1 = int(num[:2] + lower + num[1::-1])
  num2 = int(num[:2] + upper + num[1::-1])
  print_result(num1, num2, num)
public class palindromicpw {
  public static void main(String[] args) {
    FastIO sc = new FastIO();
    int n = sc.nextInt();
    while (n-- > 0) {
      String iptt = sc.next();
      char[] ipt = iptt.toCharArray();
      char[] firstFlip = new char[6];
      char[] lastFlip = new char[6];
      for (int i = 0; i < 3; i++) {
        firstFlip[i] = ipt[i];
      }
      for (int i = 3; i < 6; i++) {
        firstFlip[i] = firstFlip[6 - i - 1];
      }
      for (int i = 3; i < 6; i++) {
        lastFlip[i] = ipt[i];
      }
      for (int i = 0; i < 3; i++) {
        lastFlip[i] = ipt[6 - 1 - i];
      }
      int firstfl = Integer.parseInt(new String(firstFlip));
      int secondfl = Integer.parseInt(new String(lastFlip));
      int original = Integer.parseInt(iptt);
      if (Math.abs(firstfl - original) > Math.abs(secondfl - original)) {
        sc.println(secondfl);
      } else if (Math.abs(firstfl - original) < Math.abs(secondfl - original)) {
        sc.println(firstfl);
      } else {
        sc.println(Math.min(firstfl, secondfl));
      }
    }
    sc.close();
  }
}
