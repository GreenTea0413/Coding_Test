function solution(n, m, section) {
    var answer = 0;
    var loc = 0;
    // 벽은 1길이 n개
    // 룰러는 m 길이
    // 구역 여러개
    // 칠하면서 위치 이동하기
    for(var i = 0 ; i < section.length; i++){
        if(section[i] > loc){
            answer++;
            loc = section[i] + m - 1
        }
    }
    
    
    return answer;
}