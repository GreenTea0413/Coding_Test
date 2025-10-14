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
 * @param {number} targetSum
 * @return {boolean}
 */

var hasPathSum = function dfs(root, targetSum) {
    if(!root) return false

    if(!root.left && !root.right && targetSum === root.val) {
        return true
    }
    const remain = targetSum - root.val
    return dfs(root.left, remain) || dfs(root.right, remain)
};