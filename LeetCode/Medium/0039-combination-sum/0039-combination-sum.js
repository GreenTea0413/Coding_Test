/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var answer = []
    var len = candidates.length

    function dfs(cur, start, remain){
        if(remain === 0) {
            answer.push([...cur])
            return
        }

        for(let i = start; i < len; i++){
            if(remain - candidates[i] >= 0){
                cur.push(candidates[i])
                dfs(cur, i, remain - candidates[i])
                cur.pop(candidates[i])
            }
        }
    }
    dfs([], 0, target)
    return answer
};