import java.util.*;

class Solution {
    List<List<Character>> permutations = new ArrayList<>();
    public long solution(String expression) {
        // 숫자랑 기호 나누기
        List<Long> num = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        Set<Character> opSet = new HashSet<>();
        String temp = "";
        for(char c : expression.toCharArray()){
            if(c == '-' || c == '+' || c == '*'){
                num.add(Long.parseLong(temp));
                op.add(c);
                opSet.add(c);
                temp = "";
            }
            else{
                temp += c;
            }
        }
        num.add(Long.parseLong(temp));
        
        // 순열 구해오기
        List<Character> opList = new ArrayList<>(opSet);
        permutation(opList, new ArrayList<>(), new boolean[opList.size()]);
        
        // 그리고 이제 순열 구한걸로 계산하면 됨
        long answer = 0;
        for(List<Character> perm : permutations){
            answer = Math.max(answer, Math.abs(calculate(num, op, perm)));
        }
        return answer;
    }
    
    public void permutation(List<Character> opList, List<Character> curList, boolean[] v){
        if(opList.size() == curList.size()){
            permutations.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i = 0 ; i < opList.size(); i++){
            if(!v[i]){
                v[i] = true;
                curList.add(opList.get(i));
                
                permutation(opList, curList, v);
                
                curList.remove(curList.size() - 1);
                v[i] = false;
            }
        }
    } 
    
    public Long calculate(List<Long> num, List<Character> op, List<Character> order){
        List<Long> nums = new ArrayList<>(num);
        List<Character> ops = new ArrayList<>(op);
        
        for(char or : order){
            int i = 0;
            while(i < ops.size()){
                if(ops.get(i) == or){
                    long result = compute(nums.get(i), nums.get(i+1), or);
                    nums.remove(i);
                    nums.remove(i);
                    nums.add(i, result);
                    ops.remove(i);
                }
                else{
                    i++;
                }
            }
        }
        
        return nums.get(0);
    }
    
    public Long compute(Long num1, Long num2, char op){
        if(op == '-') return num1 - num2;
        else if(op == '+') return num1 + num2;
        return num1 * num2;
    }
}