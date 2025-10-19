/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {    
    const result = []
    
    function dfs(num, cur){
        if(cur.length === k){
            result.push([...cur])
            return
        }

        for(let i = num; i < n; i++){
            cur.push(i + 1)
            dfs(i + 1, cur)
            cur.pop()
        }
    }

    dfs(0, [])
    return result
};