class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play = (int) toNum(play_time);
        int adv = (int) toNum(adv_time);
        
        // 총 플레이 타임내에서 얼만큼 실행하고 그 실행한 횟수들의 합
        // 그래서 첫시작과 끝 부분에 +와 -를 배치해서 누적합
        long[] arr = new long[play + 1];
        for(int i = 0; i < logs.length; i++){
            String[] s = logs[i].split("-");
            int start = (int)toNum(s[0]);
            int end = (int)toNum(s[1]);
            
            arr[start] += 1;
            arr[end] -= 1;
        }
        
        // 여기서 광고 몇개가 실행됐는지 누적합으로 구하기
        for(int i = 1; i <= play; i++){
            arr[i] += arr[i-1];
        }
        
        // 그리고 여기서 광고 갯수에다가 한번씩 더 더하면 총 광고 누적 시간
        for(int i = 1; i<= play; i++){
            arr[i] += arr[i-1];
        }
        
        // 광고시작시간을 젤 앞에 두었을 경우를 먼저 고려
        long startTime = 0;
        long max = arr[adv - 1];
        
        // 그 다음 광고 끝난 시점부터 +1씩 하면서 젤 많이 시청시간이 누적되는 곳을 찾기
        for(int end = adv; end < play; end ++){
            // 이게 1415로 시작하면 1416 - 1415 해서 현재 구간에서 얼마나 많이 보는가를 구하기
            long cur = arr[end] - arr[end - adv];
            
            // 그리고 현 max인 총 누적시간의 합보다 현재값이 더크면 업데이트 후 시작시간 광고시작시간 넣어주기
            if(cur > max){
                max = cur;
                startTime = end - adv + 1;
            }
        }
        int h = (int)(startTime / 3600);
        int m = (int)(startTime % 3600) / 60;
        int s = (int)(startTime % 60);
        
        return String.format("%02d:%02d:%02d",h,m,s);
    }
    
    public long toNum(String s){
        String[] arr = s.split(":");
        return Long.parseLong(arr[0]) * 3600 + Long.parseLong(arr[1]) * 60 + Long.parseLong(arr[2]);
        
    }
}