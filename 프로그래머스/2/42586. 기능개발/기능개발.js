function solution(progresses, speeds) {
    var answer = [];
    
    // 0번째 시작해서 돌린다
    // (100 - p[i]) / s[i] >  (100 - p[j]) / s[j]
    // i = 0 j = 1 부터 시작
    // 그래서 조건에 맞으면 j +=1 해서 i이랑 또 비교
    // 그러다가 뒤에가 더 오래 걸리면
    // i = j; j = j += 1; idx += 1;

    let idx = 0;
    let i = 0;
    let j = 1;
    let count = 1;
    let A = 0;
    let B = 0;
    while(j != progresses.length + 1){
        
        // 앞에 기능을 배포하는데 더 오래 걸린다면?
        if(Math.ceil((100 - progresses[i]) / speeds[i]) >=  
            Math.ceil((100 - progresses[j]) / speeds[j])){
            // 배포 하는 기능 += 1;
            // j는 이제 다음 기능에 대한 배열 수 구하기 위해서
            count += 1;
            j++;
        }
        else{
            i = j;                  // 이제 더 오래 걸리는걸 i로 두고
            j++;                    // j는 다음 걸 가르키고
            answer[idx] = count;    // answer의 idx 위치에는 count 값 들어가야하고
            idx++;                  // 이제 다음 배열로 가야하고
            count = 1;              // count 초기화
        }
    }
    return answer;
}