/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    const result = []
    const visited = Array.from({length : nums.length}, ()=> false)

    function dfs(cur){
        if(cur.length === nums.length){
            result.push([...cur])
            return
        }

        for(let i =0; i < nums.length; i++){
            if(!visited[i]){
                visited[i]= true
                cur.push(nums[i])
                dfs(cur)
                cur.pop()
                visited[i] = false
            }
        }
    }


    dfs([])

    return result
};