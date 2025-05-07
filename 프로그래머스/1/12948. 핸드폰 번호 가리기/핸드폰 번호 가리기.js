function solution(phone_number) {
    var answer = '';
    
    for(let i = 0; i < phone_number.length; i++){
        if(phone_number.length - i <= 4) answer += phone_number[i];
        else answer += '*';
        
    }
    return answer;
}