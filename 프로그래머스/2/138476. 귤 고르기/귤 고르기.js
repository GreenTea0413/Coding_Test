function solution(k, tangerine) {
    var answer = 0;
    let arr = [];
    let idx = 0;
    
    tangerine.sort((a,b) => a- b);
    // k 만큼 가져올 때 종류가 최소일 때
    // 정렬 후에 앞에 값이랑 동일하면 idx += 1, 안의 값도 += 1;
    for (let i = 1; i < tangerine.length; i++){
        if(!arr[idx]) arr[idx] = 1;
        if(tangerine[i] == tangerine[i-1]){
            arr[idx] += 1;
        }
        else idx += 1;
    }
    // 이거 크기에 따라 몇개 있는지 보는거잖아
    // 앞에서 부터 시작하니까
    arr.sort((a,b) => b - a);
    // 맞네 여기서 최대한 하나씩 빼서 크기를 맞추면 됨
    // arr[idx] -= 1 씩해서 0이 아닐때까지 += 1을 하고
    // k == answer 되면 끝내면 되겠네 그 때 i의 위치 +1 하면 되겠넹
    console.log(arr);
    let idx2 = 0;
    
    // 2, 2, 2, 1, 1
    while (k != 0){
        // 1, 2, 2, 1, 1 K = 6
        // 0, 2, 2, 1, 1 k = 5
        // 0, 1, 2, 1, 1 k = 4
        // 0, 0, 2, 1, 1 k = 3
        // 0, 0, 1, 1, 1 k = 2
        if(arr[idx2] == 0) idx2 += 1;
        arr[idx2] -= 1;
        k--;
    }
    return idx2 + 1;
}