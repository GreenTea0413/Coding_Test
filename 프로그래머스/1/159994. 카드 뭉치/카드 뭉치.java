class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 카드 뭉치 2개를 무조건 순서대로 
        // Cards1 Index 0, Cards2 Index 0 으로 시작해서 
        
        // goal Index 0 이랑 비교 2번해서 있는거 꺼내기
        // 그리고 있으면 해당 cards의 index 상승
        int idx1 = 0;
        int idx2 = 0;
        int goalIdx = 0;
        
        while(goalIdx < goal.length){
            String g = goal[goalIdx];
            
            if (idx1 < cards1.length && cards1[idx1].equals(g)) {idx1 += 1; goalIdx += 1;}
            else if(idx2 < cards2.length && cards2[idx2].equals(g)) {idx2 += 1; goalIdx += 1;}
            else break;
        }
        
        if (goalIdx == goal.length ) return "Yes";
        else return "No";
    }
}