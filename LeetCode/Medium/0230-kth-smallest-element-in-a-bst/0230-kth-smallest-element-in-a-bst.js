/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    let answer = 0;
    let count = 0;
    function dfs(root){
        if(!root) return
        
        dfs(root.left)

        count++;
        if(count === k) {
            answer = root.val
            return
        }
        dfs(root.right)
    }

    dfs(root)
    return answer
};