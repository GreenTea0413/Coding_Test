import java.util.*;

class Solution {
    int[] answer = new int[]{0,0};
    int[][] users;
    int[] emoticons;
    int[] discount;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.discount = new int[]{10,20,30,40};
        // emoticons의 할인율은 내가 정함 이모티콘 기이가 7이니까
        // 7개 순열로 40 40 40 40 40 40... 경우의 수를 만들어서 
        // answer[0]이 항상 먼저 비교된다음에 높아야함 // answer[0] ==이랑 만약에 같으면 판매액이 달라야함
        dfs(0, new int[emoticons.length]);
        return answer;
    }
    
    void dfs(int depth, int[] dis){
        if(depth == emoticons.length){
            calculate(dis);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            dis[depth] = discount[i];
            dfs(depth + 1, dis);
        }
    }
    
    void calculate(int[] dis){
        int[] arr = new int[2];
        
        for(int i = 0; i < users.length; i++){
            int buy = 0;
            for(int j = 0; j < emoticons.length; j++){
                // 할인율이 더 크면 산다!
                if(users[i][0] <= dis[j]) buy += (emoticons[j] * (100 - dis[j])) / 100;
            }
            if(buy >= users[i][1]) arr[0] ++;
            else arr[1] += buy;
        }
        
        if(arr[0] > answer[0]) answer = arr;
        else if(arr[0] == answer[0]) answer[1] = Math.max(arr[1], answer[1]);
    }
}