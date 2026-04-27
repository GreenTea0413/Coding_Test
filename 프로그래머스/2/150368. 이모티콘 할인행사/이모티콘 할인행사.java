import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] sales = {40, 30, 20, 10};
        int m = emoticons.length;
        
        permute(sales, new ArrayList<>(), m);
        
        // [40, 40], [40, 30]...
        for(int[] sale : list){
            int sub = 0;
            int totalMoney = 0;

            // 그럼 이제 사람한테서 이 이모티콘을 살지 말지를 정해야함
            for(int i = 0; i <users.length; i ++){
                int buyMoney = 0;
                
                // 이모티콘 구매를 하는거임
                // user가 선호하는 할인율보다 큰 애들만 구매
                for(int j = 0; j < m; j++){
                    if(users[i][0] <= sale[j]){
                        buyMoney += emoticons[j] * (100 - sale[j]) / 100;
                    }
                }
                // 구매한 금액이 user가 원ㅇ하는 금액보다 넘으면 구독 아니면 그냥 구독 없이 total금액만 증가
                if (buyMoney >= users[i][1]) {sub += 1;}
                else {totalMoney += buyMoney;}
                
            }
            
            if (sub > answer[0]) {
                answer[0] = sub;
                answer[1] = totalMoney;
            }
            else if(sub == answer[0] && totalMoney >= answer[1]){
                answer[1] = totalMoney;
            }
            // System.out.printf("[구독 : %d 판매 : %d]", sub, totalMoney);
            // System.out.println();
        }
        
        return answer;
    }
    
    public void permute(int[] sales, List<Integer> cur, int end){
        if(cur.size() == end){
            list.add(cur.stream().mapToInt(i -> i).toArray());
            return;
        }
        
        for(int i = 0; i < 4; i++){
            cur.add(sales[i]);
            permute(sales, cur, end);
            cur.remove(cur.size() - 1);
        }
    }
}