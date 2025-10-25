/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    var answer = []
    var len = candidates.length
    candidates.sort((a,b) => a - b)

    function dfs(cur, start, remain){
        if(remain === 0){
            answer.push([...cur])
            return
        }

        for(let i = start; i < len; i++){
            if(i > start && candidates[i] === candidates[i - 1]) continue
            if (candidates[i] > remain) break
            cur.push(candidates[i])
            dfs(cur, i + 1, remain - candidates[i])
            cur.pop()

        }
    }
    dfs([], 0, target)
    return answer
};