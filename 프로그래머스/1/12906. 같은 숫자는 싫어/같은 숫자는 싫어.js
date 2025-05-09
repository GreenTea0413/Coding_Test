function solution(arr)
{
    var answer = [];
    let idx = 0;
    while(idx != arr.length){
        // 일단 숫자 하나 저장
        // 뒤랑 다르면 arr[idx] != arr[idx + 1]
        // idx += 1;
        if(arr[idx] != arr[idx+1]){
            answer.push(arr[idx]);
        }
        idx += 1;
    }
    
    return answer;
}