import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        String[] str = read.readLine().trim().split(" ") ;
        int n = Integer.parseInt(str[0]) ;
        int k = Integer.parseInt(str[1]) ;
        str = read.readLine().trim().split(" ") ;
        int[] arr = new int[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(str[i]) ;
        }

        Deque<Integer> dq = new LinkedList<>() ;
        for(int i=0; i<k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast() ;   
            }
            dq.addLast(i);
        }
        for (int i = k; i < arr.length; i++) {
            System.out.print(arr[dq.peekFirst()] + " ");
            while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst() ;
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast() ;   
            }
            dq.addLast(i);

        }
        System.out.println(arr[dq.peekFirst()]);
    }
}