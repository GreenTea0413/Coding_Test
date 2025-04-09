import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int left = 0;
		int right = -1;
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		while(left <= right) {
			int mid = (left + right) / 2;
			long budget = 0;
			
			for(int i=0; i<N; i++) {
				if(arr[i] > mid)
					budget += mid;
				else
					budget += arr[i];
			}
			
			if(budget <= M)
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println(right);	
	}
}