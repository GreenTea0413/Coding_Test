class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int xLen = park.length;
        int yLen = park[0].length();
        
        int x = 0; int y = 0;
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(park[i].charAt(j) =='S') {x = i; y = j;}
            }
        }
        
        for(int i = 0; i < routes.length; i++){
            String[] arr = routes[i].split(" ");
            int num = Integer.parseInt(arr[1]);
            int nx = x; int ny = y;
            boolean check = true;
            for(int n = 1; n <= num; n++){
                if(arr[0].equals("E")) ny = y + n;
                if(arr[0].equals("S")) nx = x + n;
                if(arr[0].equals("W")) ny = y - n;
                if(arr[0].equals("N")) nx = x - n;
                
                if(nx < 0 || nx >= xLen || ny < 0 || ny >= yLen || park[nx].charAt(ny) == 'X') {
                    check = false;
                    break;   
                }
            }
            
            if(check) {x = nx; y = ny;}
            
        }
        answer[0] = x; answer[1] = y;
        return answer;
    }
}