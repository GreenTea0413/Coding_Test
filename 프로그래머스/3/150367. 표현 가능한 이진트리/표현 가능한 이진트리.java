class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            long num = numbers[i];
            String temp = "";
            while(num > 0){
                long rest = num % 2;
                temp = String.valueOf(rest) + temp;
                num = num / 2;
            }
            
            // 이렇게 되면 일단 temp가 111 인데 이진트리 만들려면 총 갯수가 1 3 7 이렇게 가야함
            int l = 1;
            while(temp.length() > l){
                l = l * 2 + 1;
                
                while(temp.length() < l){
                    temp = "0" + temp;
                }
            }
            
            // 이렇게 하면 7은 111
            // 42는 101010 -> 0101010
            // System.out.println(temp);
            // 이제 이진트리가 맞는지 확인하려면 우선 총 길이의 /2한 곳이 1인가 그리고 좌우로 자식들이 0 0 인데
            // 그 아래에 만약에 1있다면??
            if(check(temp, 0, temp.length() - 1)) answer[i] = 1;
        }
        return answer;
    }
    
    boolean check(String temp, int left, int right){
        if(left == right) return true;
        int mid = (left + right) / 2;
        
        if(temp.charAt(mid) == '0') {
            int leftMid = (left + mid - 1) / 2;
            int rightMid = (mid + right + 1) / 2;
            
            if(temp.charAt(leftMid) == '1' || temp.charAt(rightMid) == '1') return false;
        }
        return check(temp, left, mid - 1) && check(temp, mid + 1, right);
    }
}