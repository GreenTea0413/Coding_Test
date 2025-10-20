function solution(numbers) {
    const arr = numbers.split("")
    const result = new Set()
    const visited = Array.from({length : arr.length}, () => false)
    
    function isPrime(num){
        if(num < 2){
            return false
        }
        
        for(let i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false
        }
        
        return true
    }
    
    function dfs(cur){
        if(cur.length > 0){
            const num = Number(cur);
            if (isPrime(num)) {
                result.add(num); 
            }
        }
        
        for(let i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true
                dfs(cur + arr[i])
                visited[i] = false
            }
        }
    }

    dfs("")
    return result.size;
}