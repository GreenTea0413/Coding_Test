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
 * @return {number}
 */
var sumNumbers = function(root) {
    function dfs(root, cur){
        if(root === null) return 0
        var next = cur * 10 + root.val

        if(root.left === null && root.right === null) return next
        return dfs(root.left, next) + dfs(root.right, next)
    }

    return dfs(root, 0)
};