/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    if(amount === 0) return 0
    
    const len = coins.length;
    const queue = [[amount, 0]]
    const visited = Array.from({length: amount + 1}, () => false)
    visited[amount] = true

    while(queue.length > 0){
        const cur = queue.shift()
        const remainAmount = cur[0]
        const count = cur[1]

        if(remainAmount == 0) return count

        for(const coin of coins){
            const next = remainAmount - coin
            if(next >= 0 && !visited[next]){
                queue.push([next, count + 1])
                visited[next] = true
            } 
        }
    }
    return -1
};