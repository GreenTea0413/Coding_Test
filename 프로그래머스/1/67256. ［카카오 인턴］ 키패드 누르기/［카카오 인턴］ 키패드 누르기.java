import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        List<int []>[] phone = new ArrayList[12];
        for(int i =0 ; i < 12; i++){
            phone[i] = new ArrayList<>();
        }
        phone[0].add(new int[]{3,1});
        phone[1].add(new int[]{0,0});
        phone[2].add(new int[]{0,1});
        phone[3].add(new int[]{0,2});
        phone[4].add(new int[]{1,0});
        phone[5].add(new int[]{1,1});
        phone[6].add(new int[]{1,2});
        phone[7].add(new int[]{2,0});
        phone[8].add(new int[]{2,1});
        phone[9].add(new int[]{2,2});
        phone[10].add(new int[]{3,0}); // *
        phone[11].add(new int[]{3,2}); // #
        
        int[] left = new int[]{3,0};
        int[] right = new int[]{3,2};
        
        // for(int[] arr : graph[찾는 곳])
        // 그럼 2중 for으로 돌리면 되나?
        for(int num : numbers){
            for(int [] arr : phone[num]){
                if(num == 1 || num == 4 || num == 7){
                    //왼손 사용
                    answer += "L";
                    left[0] = arr[0];
                    left[1] = arr[1];
                }
                else if(num == 3 || num == 6 || num == 9){
                    //오른손 사용
                    answer += "R";
                    right[0] = arr[0];
                    right[1] = arr[1];
                }
                else{
                    int l_dist = Math.abs(left[0] - arr[0]) + Math.abs(left[1]-arr[1]);
                    int r_dist = Math.abs(right[0] - arr[0]) + Math.abs(right[1] - arr[1]);
                    // 왼쪽이 작으면
                    if(l_dist < r_dist){
                        answer += "L";
                        // 좌표 옮겨주기
                        left[0] = arr[0];
                        left[1] = arr[1];
                    }
                    // 오른쪽이 작으면
                    if(r_dist < l_dist){
                        answer += "R";
                        right[0] = arr[0];
                        right[1] = arr[1];
                    }
                    // 같으면
                    if(l_dist == r_dist){
                        if(hand.equals("right")){
                            answer += "R";
                            right[0] = arr[0];
                            right[1] = arr[1];
                        }
                        if(hand.equals("left")){
                            answer += "L";
                            left[0] = arr[0];
                            left[1] = arr[1];
                        }     
                    }
                }           
                // System.out.println("왼" + left[0] + ", " +left[1]);
                // System.out.println("오" + right[0] + ", " +right[1]);
                // System.out.println("폰" + x + ", " +y);
            }
        }
        return answer;
    }
}