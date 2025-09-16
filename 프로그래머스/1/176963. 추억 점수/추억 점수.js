function solution(name, yearning, photo) {
    var answer = [];
    var hashMap = new Map();
    
    for(let i = 0; i < name.length; i++){
        hashMap.set(name[i], yearning[i]);
    }
    for(let j = 0; j < photo.length; j++){
        let sum = 0;
        for(let k = 0; k <photo[j].length; k++){
            if (hashMap.has(photo[j][k])) {
                sum += hashMap.get(photo[j][k]);
            }
        }
        answer.push(sum);
    }
    return answer;
}