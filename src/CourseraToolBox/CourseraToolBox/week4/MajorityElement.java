package CourseraToolBox.CourseraToolBox.week4;
import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] arr, int left, int right) {
    	 HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	 
         for(int i = 0; i < arr.length; i++) {
             if (map.containsKey(arr[i])) {
                     int count = map.get(arr[i]) +1;
                     if (count > arr.length /2) {
                         return 1;
                     } else
                         map.put(arr[i], count);
  
             }
             else
                 map.put(arr[i],1);
             }
             return 0;
     }
    


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
            System.out.println(getMajorityElement(a, 0, a.length));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

