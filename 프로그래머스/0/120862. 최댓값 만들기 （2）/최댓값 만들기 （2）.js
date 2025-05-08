function solution(numbers) {  
    numbers.sort((a,b) => b-a);
    
    var answer = numbers[0] * numbers[1];
    if(answer < numbers[numbers.length-1] * numbers[numbers.length-2])
        answer = numbers[numbers.length-1] * numbers[numbers.length-2];
    return answer;
}