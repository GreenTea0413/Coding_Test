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
var maxPathSum = function(root) {
    let answer = -Infinity

    function dfs(root){
        if(!root) return 0

        const left = Math.max(dfs(root.left),0)
        const right = Math.max(dfs(root.right),0)

        answer = Math.max(answer, root.val + left + right)

        return root.val + Math.max(left, right)
    }

    dfs(root)
    return answer
};