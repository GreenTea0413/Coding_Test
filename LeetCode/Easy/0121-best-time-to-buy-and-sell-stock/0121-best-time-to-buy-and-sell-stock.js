/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var min = Infinity
    var max = 0

    for(const price of prices){
        if(price < min){
            min = price
        }
        else{
            max = Math.max(max, price - min)
        }
    }

    return max
}