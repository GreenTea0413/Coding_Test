function solution(numbers) {
    var answer = 0;
    
    for(num of numbers) answer += num;
    return answer / numbers.length;
}