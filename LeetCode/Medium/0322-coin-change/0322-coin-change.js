/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
    const len = coins.length
    const visited = Array.from({length : amount + 1}, () => false)
    const queue = [[amount, 0]]

    let idx = 0

    while(idx < queue.length){
        const [remain, count] = queue[idx++]
        if(remain === 0) return count

        for(const coin of coins){
            let next = remain - coin
            if(!visited[next] && next >= 0){
                visited[next] = true
                queue.push([next, count + 1])
            }
        }
    }

    return -1
};