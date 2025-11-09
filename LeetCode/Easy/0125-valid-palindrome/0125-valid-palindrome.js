/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    var string = s.replace(/[^0-9a-zA-Z]/g,'').toLowerCase()

    var len = string.length
    console.log(string)
    for(let i = 0; i <= len / 2; i++){
       if(string[i] !== string[len - i - 1]){
            return false
        }
    }

    return true
};