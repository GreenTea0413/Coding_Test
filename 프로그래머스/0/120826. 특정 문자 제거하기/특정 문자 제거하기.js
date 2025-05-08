function solution(my_string, letter) {
    var answer = '';
    for(c of my_string){
        if(c != letter) answer += c;
    }
    return answer;
}