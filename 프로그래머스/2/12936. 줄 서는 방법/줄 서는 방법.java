import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        // 모든 순열을 돌리면 터지니까 순열 갯수만 구하기 3자리면 6이나오고
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for(int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;
        
        // 이거는 fact로 일단 해당 자리수 까지 구할 수 있는 갯수를 구하고
        // 거기서 넣을 수를 구하면 되는거 같은데
        // 그러면 위치마다 일단 0 -> 1 1 -> 2 2 -> 3
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(i);
        
        // n개 만큼 담아야하는데
        // k가 5면 3 1 2 -> 2 0 1을 담아야함
        // 그럴려면 k가 몇번째에 있는지를 알아야하는데 지금 list를 0 index로 맞췄으니 여기도 0에 맞게 해줘야함
        k--;
        
        // 여기서 그러면 이제 i 위치에다가 값을 넣을건데 fact의 위치가 총 갯수를 뜻함
        // 거기서 fact가 지금 1 2 6을 담고 있으니
        // 처음에 6개 중에서 4 / 2 하면 idx = 2;
        // 그래서 젤 앞에는 3이나오고 
        for(int i = 0; i < n; i++){
            long f = fact[n - i - 1];
            int idx = (int) (k / f);
            k %= f;
            
            answer[i] = list.remove(idx);
        }
        
        return answer;
    }
}