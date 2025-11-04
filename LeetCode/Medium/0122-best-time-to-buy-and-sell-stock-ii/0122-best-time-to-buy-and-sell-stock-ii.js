/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var max = 0
    
    for(let i =0; i < prices.length; i++){
        if(prices[i] < prices[i + 1]){
            max += prices[i + 1] - prices[i]
        }
    }
    
    return max
};