import java.util.*;

class Solution {
    List<List<Character>> perList = new ArrayList<>();
    
    public long solution(String expression) {
        // 일단 * + - 를 정해 놓고 뭐 부터 먼저할지를 정해야함
        // * + -이 클수도 있고 + * - 가 클 수도 있기때문에
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        Set<Character> opSet = new HashSet<>();
        // temp에는 문자 하나씩 쪼개서 넣으면 숫자 끊기니까 쌓아뒀다가 기호나오면 넣기
        String temp = "";
        for(char c : expression.toCharArray()){
            if(c == '-' || c == '+' || c == '*'){
                nums.add(Long.parseLong(temp));
                ops.add(c);
                opSet.add(c);
                temp = "";
            }
            else temp += c;
        }
        // 마지막 숫자까지 넣어주기
        nums.add(Long.parseLong(temp));
        
        // 100 200 300 500 20 
        //    -   *   -   +    이렇게 해놓고 i번째면 op.get(i)랑 nums.get(i) , nums.get(i + 1) 계산
        // 근데 계산순서를 정해야함
        List<Character> orderList = new ArrayList<>(opSet);
        permutation(orderList, new ArrayList<>(), new boolean[opSet.size()]);
        
        
        // perList에 이제 계산 순서 리스트 만들어 놨으니 하나씩 다 해보기
        long answer = 0;
        for(List<Character> per : perList){
            answer = Math.max(answer, Math.abs(calculation(per, nums, ops)));
        }
        return answer;
    }
    
    void permutation(List<Character> orderList, List<Character> calList, boolean[] v){
        // calList에다가 이제 계산 순서들 넣어넣고 다 채워지면 perList 순열 리스트에 넣기
        if(orderList.size() == calList.size()) {
            perList.add(new ArrayList<>(calList));
            return;
        }
        
        for(int i = 0; i < orderList.size(); i++){
            if(!v[i]){
                v[i] = true;
                calList.add(orderList.get(i));
                
                permutation(orderList, calList, v);
                
                v[i] = false;
                calList.remove(calList.size() - 1);
            }
        }
    }
    
    // 여기서 이제 * + - 든, + * - 든 순서 정해진게옴
    // 그래서 하나씩 꺼내서 맞는거 있는지 확인 해야함
    Long calculation(List<Character> per, List<Long> nums, List<Character> ops){
        List<Long> tempNums = new ArrayList<>(nums);    
        List<Character> tempOps = new ArrayList<>(ops);
        
        for(char p : per){
            int i = 0;
            while(i < tempOps.size()){
                // * + -에서 * 먼저했을 때 이거랑 ops.get에서 i 가져오는거랑 같으면 계산하면 됨
                if(tempOps.get(i) == p){
                    Long num = calculate(tempNums.get(i), tempNums.get(i + 1), tempOps.get(i));
                    // i번째 없애고 또 다시 없애면 순서대로 오니까 i + 1도 삭제 되는거임
                    // 그리고 계산한 값을 i번째에 넣기
                    tempNums.remove(i);
                    tempNums.remove(i);
                    tempNums.add(i, num);
                    tempOps.remove(i);
                }
                // 맞는거 없으면 그냥 뒤로 가면 됨
                else i++;
            }
        }
        return tempNums.get(0);
    }
    
    public Long calculate(Long num1, Long num2, char op){
        if(op == '-') return num1 - num2;
        else if(op == '+') return num1 + num2;
        return num1 * num2;
    }
}