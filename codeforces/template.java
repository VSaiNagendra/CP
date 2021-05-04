import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		int t = 1;
		t = ni();
		for (int _t = 1; _t <= t; _t++) {
			// ps("Case " + (_t) + ":");

		}
		flush();
	}

	static Reader in = new Reader();
	static StringBuilder output = new StringBuilder();
	static final int imod = 1000_000_007;
	static final long mod = 1000_000_007;
	static final int imax = 1000_000_000;
	static final int imin = -1000_000_000;
	static final long lmax = 1000_000_000_000_000_000L;
	static final long lmin = -1000_000_000_000_000_000L;

	//input functions
	static int ni() {return Integer.parseInt(in.next());}
	static long nl() {return Long.parseLong(in.next());}
	static String nextLine() {try {return in.reader.readLine(); } catch (Exception e) {e.printStackTrace(); System.exit(1); return "";}}
	static String ns() {return in.next();}
	static double nd() {return Double.parseDouble(in.next());}
	static int[] eia(int n) {int a[] = new int[n]; return a;}
	static long[] ela(int n) {long a[] = new long[n]; return a;}
	static double[] eda(int n) {double a[] = new double[n]; return a;}
	static String[] esa(int n) {String a[] = new String[n]; return a;}
	static int[] nia(int n) {int a[] = new int[n]; for (int i = 0; i < n; i++)a[i] = ni(); return a;}
	static long[] nla(int n) {long a[] = new long[n]; for (int i = 0; i < n; i++)a[i] = nl(); return a;}
	static String[] nsa(int n) {String a[] = new String[n]; for (int i = 0; i < n; i++)a[i] = ns(); return a;}
	static double[] nda(int n) {double a[] = new double[n]; for (int i = 0; i < n; i++)a[i] = nd(); return a;}

	//output functions
	static void print(String a[]) {for (String i : a) System.out.print(i + " "); System.out.println();}
	static void print(int a[]) {for (int i : a) System.out.print(i + " "); System.out.println();}
	static void print(long a[]) {for (long i : a) System.out.print(i + " "); System.out.println();}
	static void print(double a[]) {for (double i : a) System.out.print(i + " "); System.out.println();}
	static void print(Object... a) {for (Object i : a) {System.out.print(i); System.out.print(" ");} System.out.println();}
	static void println(Object... a) {for (Object i : a) {System.out.print(i); System.out.print("\n");}}
	static void println() {System.out.println();}
	static void flush() {System.out.print(output); output = new StringBuilder();}
	static void pln(int []a) {for (int i : a) {output.append(i).append('\n');}}
	static void pln(long []a) {for (long i : a) {output.append(i).append('\n');}}
	static void pln(double []a) {for (double i : a) {output.append(i).append('\n');}}
	static void pln(String []a) {for (String i : a) {output.append(i).append('\n');}}
	static void pln(Object...a) {for (Object i : a) {output.append(i).append('\n');}}
	static void pln() {output.append('\n');}
	static void p(int []a) {for (int i : a) {output.append(i);}}
	static void p(long []a) {for (long i : a) {output.append(i);}}
	static void p(double []a) {for (double i : a) {output.append(i);}}
	static void p(String []a) {for (String i : a) {output.append(i);}}
	static void p(Object[] a) {for (Object i : a) {output.append(i);}}
	static void ps() {output.append(" ");}
	static void ps(int []a) {for (int i : a) {output.append(i).append(" ");}}
	static void ps(long []a) {for (long i : a) {output.append(i).append(" ");}}
	static void ps(double []a) {for (double i : a) {output.append(i).append(" ");}}
	static void ps(String []a) {for (String i : a) {output.append(i).append(" ");}}
	static void ps(Object... a) {for (Object i : a) {output.append(i).append(" ");}}



	//Utility functions
	static int lowerbound(int[]a, int key) { // returns index of smallest element larger than equal to given element between indices l and r inclusive
		int low = 0, high = a.length - 1, mid = (low + high) / 2; while (low < high) {if (a[mid] >= key)high = mid; else low = mid + 1; mid = (low + high) / 2;} return mid;
	}
	static int upperbound(int[]a, int key) {int low = 0, high = a.length - 1, mid = (low + high + 1) / 2; while (low < high) {if (a[mid] <= key) low = mid; else high = mid - 1; mid = (low + high + 1) / 2;} return mid;}
	static int lowerbound(int[]a, int l, int r, int key) { int low = l, high = r, mid = (low + high) / 2; while (low < high) { if (a[mid] >= key) high = mid; else low = mid + 1; mid = (low + high) / 2;} return mid;}
	static int upperbound(int[]a, int l, int r, int key) { // returns index of largest element smaller than equal to given element
		int low = l, high = r, mid = (low + high + 1) / 2; while (low < high) { if (a[mid] <= key) low = mid; else high = mid - 1; mid = (low + high + 1) / 2;} return mid;
	}

	static long powm(long a, long b, long mod) {long an = 1; long c = a % mod; while (b > 0) {if (b % 2 == 1)an = (an * c) % mod; c = (c * c) % mod; b >>= 1;} return an;}
	static long powm(long a, long b) {long an = 1; long c = a % mod; while (b > 0) {if (b % 2 == 1)an = (an * c) % mod; c = (c * c) % mod; b >>= 1;} return an;}
	static long pow(long a, long b) {long an = 1; long c = a; while (b > 0) {if (b % 2 == 1)an *= c; c *= c; b >>= 1;} return an;}
	static void reverse(int[]a) {for (int i = 0; i < a.length / 2; i++) {a[i] ^= a[a.length - i - 1]; a[a.length - i - 1] ^= a[i]; a[i] ^= a[a.length - i - 1];}}
	static void exit() {System.exit(0);}
	static int min(int... a) {int min = a[0]; for (int i : a)min = Math.min(min, i); return min;}
	static long min(long... a) {long min = a[0]; for (long i : a)min = Math.min(min, i); return min;}
	static double min(double... a) {double min = a[0]; for (double i : a)min = Math.min(min, i); return min;}
	static double max(double... a) {double max = a[0]; for (double i : a)max = Math.max(max, i); return max;}
	static int max(int... a) {int max = a[0]; for (int i : a)max = Math.max(max, i); return max;}
	static long max(long... a) {long max = a[0]; for (long i : a)max = Math.max(max, i); return max;}
	static long gcd(long... a) {long gcd = a[0]; for (long i : a)gcd = gcd(gcd, i); return gcd;}
	static int gcd(int... a) {int gcd = a[0]; for (int i : a)gcd = gcd(gcd, i); return gcd;}
	static int gcd(int a, int b) {if (b == 0)return a; if (a == 0) return b; return gcd(b, a % b);}
	static long gcd(long a, long b) {if (b == 0)return a; if (a == 0) return b; return gcd(b, a % b);}

	static class Pair {
		long la, lb;
		int a, b;
		double da, db;
		String sa, sb;
		Pair() {} Pair(int c, int d) {a = c; b = d;}
		Pair(long c, long d) {la = c; lb = d;}
		Pair(int c, long d) { a = c; lb = d; }
		Pair(long c, int d) { la = c; b = d; }
		Pair(int c, double d) { a = c; db = d; }
		Pair(double c, double d) { da = c; db = d; }
		Pair(double c, int d) { da = c; b = d; }
		Pair(String sa, String sb) {this.sa = sa; this.sb = sb;}
		@Override
		public int hashCode() { return (a + " " + b).hashCode(); }
		public boolean equals(Object c) { return (a == (((Pair)c).a) && b == (((Pair)c).b)); }
	}

	static class Reader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public Reader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
	}
}
class AL<T> extends java.util.ArrayList<T> {}
class HM<T, L> extends java.util.HashMap<T, L> {}
class HS<T> extends java.util.HashSet<T> {}

